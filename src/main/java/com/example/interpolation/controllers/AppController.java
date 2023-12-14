package com.example.interpolation.controllers;

import com.example.interpolation.Chart;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class AppController extends ImplementativeController{
    public void initialize() {
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        scatterChart.setPrefSize(width, height);
        List<XYChart.Data<Number, Number>>  dataPoints = new ArrayList<>();

        series.getData().addAll(dataPoints);
        scatterChart.getData().add(series);

        scatterChart.setOnMouseClicked(event -> {
            handleMouseClick(event, chart);
        });
        scatterChart.setOnScroll(this::handleScroll);
        scatterChart.setOnMousePressed(this::handleMousePressed);
        scatterChart.setOnMouseDragged(this::handleMouseDragged);
        scatterChart.setOnMouseReleased(this::handleMouseReleased);
    }

    public ScatterChart<Number, Number> getScatterChart(){
        return scatterChart;
    }
}
