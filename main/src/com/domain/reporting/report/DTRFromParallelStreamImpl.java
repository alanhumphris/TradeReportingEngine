/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report;

import com.domain.reporting.report.core.ReportLine;
import com.domain.reporting.report.core.SettlementReportLine;
import com.domain.reporting.model.EnumCurrencyInfo;
import com.domain.reporting.model.EnumTradeDirection;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.report.core.BlankLine;
import com.domain.reporting.report.core.EntityRankingReportLine;
import com.domain.reporting.report.core.SimpleText;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 *
 * @author Alan Humphris
 */
public class DTRFromParallelStreamImpl implements DailyTradeReport {

    @Override
    public List<ReportLine> dailySettlementIncomingSummary(List<InstructionProcessed> instructions) {
        List<ReportLine> result = new ArrayList();
        result.add(new SimpleText("Daily Incoming Settlement"));

        if ((instructions == null) || (instructions.isEmpty())) {
            result.add(new SimpleText("No instructions to report"));
            result.add(new BlankLine());
            return result;
        }

        ConcurrentMap<LocalDate, Double> sumByDate = generateDailySummary(instructions, EnumTradeDirection.INCOMING);

        if ((sumByDate != null) && (sumByDate.size() > 0)) {
            List<ReportLine> tempResult = sumByDate.entrySet().parallelStream().sorted(Comparator.comparing(e -> e.getKey()))
                    .map(e -> new SettlementReportLine(e.getKey(), e.getValue(), EnumCurrencyInfo.US_DOLLAR, EnumTradeDirection.INCOMING)).collect(Collectors.toList());

            result.addAll(tempResult);

        }
        result.add(new BlankLine());

        return result;
    }

    @Override
    public List<ReportLine> dailySettlementOutgoingSummary(List<InstructionProcessed> instructions) {
        List<ReportLine> result = new ArrayList();
        result.add(new SimpleText("Daily Outgoing Settlement"));

        if ((instructions == null) || (instructions.isEmpty())) {
            result.add(new SimpleText("No instructions to report"));
            result.add(new BlankLine());
            return result;
        }

        ConcurrentMap<LocalDate, Double> sumByDate = generateDailySummary(instructions, EnumTradeDirection.OUTGOING);

        if ((sumByDate != null) && (sumByDate.size() > 0)) {
            List<ReportLine> tempResult = sumByDate.entrySet().parallelStream().sorted(Comparator.comparing(e -> e.getKey()))
                    .map(e -> new SettlementReportLine(e.getKey(), e.getValue(), EnumCurrencyInfo.US_DOLLAR, EnumTradeDirection.OUTGOING)).collect(Collectors.toList());

            result.addAll(tempResult);
        }
        result.add(new BlankLine());

        return result;
    }

    @Override
    public List<ReportLine> entityRanking(List<InstructionProcessed> instructions) {
        List<ReportLine> result = new ArrayList();
        result.add(new SimpleText("Entity Ranking"));

        if ((instructions == null) || (instructions.isEmpty())) {
            result.add(new SimpleText("No instructions to report"));
            result.add(new BlankLine());
            return result;
        }

        // outgoing section
        ConcurrentMap<String, Optional<InstructionProcessed>> outgoingMaxByEntity
                = generateEntityRanking(instructions, EnumTradeDirection.OUTGOING);

        result.add(new SimpleText("Outgoing Ranking"));
        if ((outgoingMaxByEntity != null) && (outgoingMaxByEntity.size() > 0)) {
            List<ReportLine> tempResult = outgoingMaxByEntity.entrySet().parallelStream().sorted(Comparator.comparing(e -> e.getValue().get().getTradeValueUSD(), Comparator.reverseOrder()))
                    .map(e -> new EntityRankingReportLine(e.getKey(), e.getValue().get().getTradeValueUSD(), EnumCurrencyInfo.US_DOLLAR)).collect(Collectors.toList());

            result.addAll(tempResult);
        }
        result.add(new BlankLine());

        // incoming section
        ConcurrentMap<String, Optional<InstructionProcessed>> incomingMaxByEntity
                = generateEntityRanking(instructions, EnumTradeDirection.INCOMING);

        result.add(new SimpleText("Incoming Ranking"));
        if ((incomingMaxByEntity != null) && (incomingMaxByEntity.size() > 0)) {
            List<ReportLine> tempResult = incomingMaxByEntity.entrySet().parallelStream().sorted(Comparator.comparing(e -> e.getValue().get().getTradeValueUSD(), Comparator.reverseOrder()))
                    .map(e -> new EntityRankingReportLine(e.getKey(), e.getValue().get().getTradeValueUSD(), EnumCurrencyInfo.US_DOLLAR)).collect(Collectors.toList());

            result.addAll(tempResult);
        }
        result.add(new BlankLine());

        return result;
    }

    /**
     * Amount in USD settled everyday by buy/sell flag
     *
     * Filter the instrument list on tradeDirection
     * Group by actualSettlementDate
     * Sum the tradeValueUSD
     *
     * @param instructions
     * @param tradeDirection
     * @return
     */
    protected ConcurrentMap<LocalDate, Double> generateDailySummary(List<InstructionProcessed> instructions, EnumTradeDirection tradeDirection) {
        if ((instructions == null) || (tradeDirection == null)) {
            return null;
        }

        ConcurrentMap<LocalDate, Double> result
                = instructions.parallelStream()
                        .filter(e -> e.getTradeDirection() == tradeDirection)
                        .collect(
                                Collectors.groupingByConcurrent(
                                        InstructionProcessed::getActualSettlementDate,
                                        Collectors.reducing(
                                                0.0,
                                                InstructionProcessed::getTradeValueUSD,
                                                Double::sum)));
        return result;
    }

    /**
     * Ranking of entities based on incoming and outgoing amount. E.g.: If
     * entity foo instructs the highest amount for a buy instruction, then foo
     * is rank 1 for outgoing
     *
     * Filter the instrument list on tradeDirection
     * Group by entity
     * Get the maximum tradeValueUSD
     * 
     * @param instructions
     * @param tradeDirection
     * @return
     */
    protected ConcurrentMap<String, Optional<InstructionProcessed>> generateEntityRanking(List<InstructionProcessed> instructions, EnumTradeDirection tradeDirection) {
        if ((instructions == null) || (tradeDirection == null)) {
            return null;
        }

        ConcurrentMap<String, Optional<InstructionProcessed>> result
                = instructions.parallelStream()
                        .filter(e -> e.getTradeDirection() == tradeDirection)
                        .collect(
                                Collectors.groupingByConcurrent(InstructionProcessed::getEntityName,
                                        Collectors.maxBy(Comparator.comparingDouble(InstructionProcessed::getTradeValueUSD))));

        return result;
    }
}
