package com.example.interpolation.controllers;

import com.example.interpolation.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class MainController {
    protected static double minX = -10.0d;
    protected static double maxX = 10.0d;
    protected static double minY = -10.0d;
    protected static double maxY = 10.0d;
    protected boolean isPanning = false;
    protected final static int width = 900;
    protected final static int height = 900;
    protected List<Double> xValues = new ArrayList<>();
    protected List<Double> yValues = new ArrayList<>();
    protected NumberAxis xAxis = new NumberAxis(minX, maxX, 1);
    protected NumberAxis yAxis = new NumberAxis(minY, maxY, 1);
    protected ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
    protected double lastX;
    protected double lastY;
    protected XYChart.Series<Number, Number> series = new XYChart.Series<>();
    protected Chart chart = new Chart();

    abstract protected void handleScroll(ScrollEvent event);
    abstract protected void handleMousePressed(MouseEvent event);
    abstract protected void handleMouseDragged(MouseEvent event);
    abstract protected void handleMouseClick(MouseEvent event, Chart chart);
    abstract protected void handleMouseReleased(MouseEvent event);
}
