package com.domain.reporting.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alan Humphris
 */
public enum EnumCurrencyInfo {

    // known currencies
    // if a client passes a type not in this list it will get set to 'other'
    SAUDI_RIYAL("Saudi Arabian Rihal", "SAR", DayOfWeek.SUNDAY), //
    UAE_DIRHAM("United Arab Emirates Dirham", "AED", DayOfWeek.SUNDAY), //
    STERLING("Pounds Sterling", "GBP", DayOfWeek.MONDAY), //
    US_DOLLAR("US Dollars", "USD", DayOfWeek.MONDAY), //
    OTHER("Other Currency", "OTHER", DayOfWeek.MONDAY); //

    private final String description;
    private final String currencyCode;
    private final DayOfWeek firstDayOfWeek;

    // reverse-lookup map for getting a EnumCurrency from a currency code
    private static final Map<String, EnumCurrencyInfo> lookup = new HashMap<String, EnumCurrencyInfo>();

    static {
        for (EnumCurrencyInfo eci : EnumCurrencyInfo.values()) {
            lookup.put(eci.getCurrencyCode(), eci);
        }
    }

    EnumCurrencyInfo(String description, String currencyCode, DayOfWeek firstDayOfWeek) {
        this.description = description;
        this.currencyCode = currencyCode;
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public LocalDate getWorkingDay(LocalDate date) {
        LocalDate result = date;
        
        if (date != null) {
            if (DayOfWeek.MONDAY.equals(getFirstDayOfWeek())) {
                if (DayOfWeek.SUNDAY.equals(date.getDayOfWeek())) {
                    result = result.plusDays(1);
                } else if (DayOfWeek.SATURDAY.equals(date.getDayOfWeek())) {
                    result = result.plusDays(2);
                }
            } else if (DayOfWeek.SUNDAY.equals(getFirstDayOfWeek())) {
                if (DayOfWeek.SATURDAY.equals(date.getDayOfWeek())) {
                    result = result.plusDays(1);
                } else if (DayOfWeek.FRIDAY.equals(date.getDayOfWeek())) {
                    result = result.plusDays(2);
                }
            }
        }
        
        return result;
    }
    
    public static EnumCurrencyInfo get(String currencyCode) {
        EnumCurrencyInfo result = lookup.get(currencyCode);

        if (result == null) {
            result = EnumCurrencyInfo.OTHER;
        }

        return result;
    }

    public static boolean contains(String currencyCode) {
        boolean result = lookup.get(currencyCode) != null;

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("EnumCurrencyInfo{");
        result.append("name: ");
        result.append(this.name());
        result.append(", currencyCode: ");
        result.append(currencyCode);
        result.append("description=");
        result.append(description);
        result.append("firstDayOfWeek=");
        result.append(firstDayOfWeek);
        result.append('}');

        return result.toString();
    }

}
