package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Column3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.SolidFill;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        Cartesian3d column3d = AnyChart.column3d();
        column3d.yScale().stackMode(ScaleStackMode.VALUE);
        column3d.animation(true);
        column3d.title("Tilastot");
        column3d.title().padding(0d, 0d, 15d, 0d);
        ArrayList<DataEntry> seriesData = new ArrayList<>();
        for (Lutemon lutemon: Storage.getAllLutemons()) {
            seriesData.add(new Statistics(lutemon.getName(), lutemon.getWins(), lutemon.getLosses(), lutemon.getTrainingDays()));
        }
        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Column3d series1 = column3d.column(series1Data);
        series1.name("Voitot");
        series1.fill(new SolidFill("#ffc107", 1d));
        series1.stroke("1 #f7f3f3");
        series1.hovered().stroke("3 #f7f3f3");
        Column3d series2 = column3d.column(series2Data);
        series2.name("Tappiot");
        series2.fill(new SolidFill("#f10a0a", 1d));
        series2.stroke("1 #f7f3f3");
        series2.hovered().stroke("3 #f7f3f3");
        Column3d series3 = column3d.column(series3Data);
        series3.name("Treenipäivät");
        series3.fill(new SolidFill("#0d30e4", 1d));
        series3.stroke("1 #f7f3f3");
        series3.hovered().stroke("3 #f7f3f3");
        column3d.legend().enabled(true);
        column3d.legend().fontSize(13d);
        column3d.legend().padding(0d, 0d, 20d, 0d);
        column3d.xAxis(0).stroke("1 #000000");
        column3d.xAxis(0).labels().fontSize("#000000");
        column3d.yAxis(0).stroke("1 #000000");
        column3d.yAxis(0).labels().fontColor("#000000");
        column3d.yAxis(0).labels().format("{%Value}{groupsSeparator: }");
        column3d.interactivity().hoverMode(HoverMode.BY_X);
        column3d.tooltip()
                .displayMode(TooltipDisplayMode.UNION)
                .format("{%Value} {%SeriesName}");
        column3d.yGrid(0).stroke("#000000", 1d, null, null, null);
        column3d.xGrid(0).stroke("#000000", 1d, null, null, null);
        anyChartView.setChart(column3d);
    }
}