package com.example.olio_ohjelmointi_harjoitustyo;

import com.anychart.chart.common.dataentry.ValueDataEntry;

public class Statistics extends ValueDataEntry {
    public Statistics(String x, Number value, Number value2, Number value3) {
        super(x, value);
        setValue("value2", value2);
        setValue("value3", value3);
    }
}
