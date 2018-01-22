/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alan Humphris
 */
public class TestDataHelper {

    public static final Instruction INSTRUCTION_SGP_1 = new Instruction("foo", "B", 0.5, "SGP", LocalDate.of(2016, 01, 01), LocalDate.of(2016, 01, 02), 200L, 100.25);
    public static final Instruction INSTRUCTION_AED_1 = new Instruction("bar", "S", 0.22, "AED", LocalDate.of(2016, 01, 05), LocalDate.of(2016, 01, 07), 450L, 150.5);

    public static final Instruction INSTRUCTION_SAR_1 = new Instruction("sar-firm", "S", 0.22, "SAR", LocalDate.of(2016, 01, 05), LocalDate.of(2016, 01, 07), 300L, 33.3);
    public static final Instruction INSTRUCTION_USD_1 = new Instruction("usd-firm", "S", 1.0, "USD", LocalDate.of(2016, 01, 05), LocalDate.of(2016, 01, 07), 500L, 100.0);

    public static final InstructionValidated INSTRUCTION_VALIDATED_SGP_1 = new InstructionValidated(INSTRUCTION_SGP_1);
    public static final InstructionValidated INSTRUCTION_VALIDATED_AED_1 = new InstructionValidated(INSTRUCTION_AED_1);
    public static final InstructionValidated INSTRUCTION_VALIDATED_SAR_1 = new InstructionValidated(INSTRUCTION_SAR_1);
    public static final InstructionValidated INSTRUCTION_VALIDATED_USD_1 = new InstructionValidated(INSTRUCTION_USD_1);

    public static final InstructionProcessed INSTRUCTION_PROCESSED_SGP_1 = new InstructionProcessed(INSTRUCTION_SGP_1);
    public static final InstructionProcessed INSTRUCTION_PROCESSED_AED_1 = new InstructionProcessed(INSTRUCTION_AED_1);
    public static final InstructionProcessed INSTRUCTION_PROCESSED_SAR_1 = new InstructionProcessed(INSTRUCTION_SAR_1);
    public static final InstructionProcessed INSTRUCTION_PROCESSED_USD_1 = new InstructionProcessed(INSTRUCTION_USD_1);

    /**
     * Generate instructions with random data
     *
     * @param numberOfInstructions how many instructions to create
     * @return
     */
    public static DataHolder generateRandomData(Long numberOfInstructions) {
        Random rand = new Random();
        final String entitySuffix = "ABCDEFGH";

        List<Instruction> instructions = new ArrayList();
        List<InstructionValidated> validatedInstructions = new ArrayList();
        List<InstructionProcessed> processedInstructions = new ArrayList();

        for (int i = 0; i < numberOfInstructions - 1; i++) {
            String entityName = "Entity" + entitySuffix.charAt(rand.nextInt(8));
            String buySellFlag = (rand.nextInt(2) > 0) ? "B" : "S";
            String currencyCode = generateCurrencyCode(rand);
            Double agreedFx = generateAgreedFx(currencyCode);
            LocalDate instructionDate = LocalDate.of(2018, 1, 1 + rand.nextInt(7));
            LocalDate settlementDate = LocalDate.of(2018, 1, 8 + rand.nextInt(7));
            Long units = new Long(1 + rand.nextInt(50000));
            Double pricePerUnit = (1 + rand.nextInt(10000)) / 100.0;

            Instruction instruction = new Instruction(
                    entityName,
                    buySellFlag,
                    agreedFx,
                    currencyCode,
                    instructionDate,
                    settlementDate,
                    units,
                    pricePerUnit);

            instructions.add(instruction);
            //validatedInstructions.add(new InstructionValidated(instruction));
            processedInstructions.add(new InstructionProcessed(instruction));
        }

        DataHolder dataHolder = new DataHolder(instructions, validatedInstructions, processedInstructions);

        return dataHolder;
    }

    protected static String generateCurrencyCode(Random rand) {
        String result = "USD";
        int codeNo = rand.nextInt(10);

        if (codeNo < 3) {
            result = "USD";
        } else if (codeNo < 7) {
            result = "XYZ";
        } else if (codeNo < 8) {
            result = "AED";
        } else {
            result = "SAR";
        }

        return result;
    }

    protected static Double generateAgreedFx(String currencyCode) {
        Double result = 1.0;

        if ("XYZ".equals(currencyCode)) {
            result = 1.3;
        } else if ("AED".equals(currencyCode)) {
            result = .22;
        } else if ("SAR".equals(currencyCode)) {
            result = .27;
        } else {
            result = 1.0;
        }

        return result;
    }
}
