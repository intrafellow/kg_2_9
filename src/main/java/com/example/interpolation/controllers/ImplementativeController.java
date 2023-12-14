package com.example.interpolation.controllers;

import com.example.interpolation.Chart;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class ImplementativeController extends MainController{

    @Override
    protected void handleScroll(ScrollEvent event) {
        double delta = event.getDeltaY();
        double zoomFactor = 1.1;

        // Изменение масштаба графика при прокрутке
        if (delta < 0) {
            minX /= zoomFactor;
            maxX /= zoomFactor;
            minY /= zoomFactor;
            maxY /= zoomFactor;
        } else {
            minX *= zoomFactor;
            maxX *= zoomFactor;
            minY *= zoomFactor;
            maxY *= zoomFactor;
        }

        // Обновление границ осей
        xAxis.setLowerBound(minX);
        xAxis.setUpperBound(maxX);
        yAxis.setLowerBound(minY);
        yAxis.setUpperBound(maxY);

        event.consume();
    }

    @Override
    protected void handleMousePressed(MouseEvent event) {
        lastX = event.getX();
        lastY = event.getY();
        isPanning = true;
    }

    @Override
    protected void handleMouseDragged(MouseEvent event) {
        if (isPanning) {
            double deltaX = event.getX() - lastX;
            double deltaY = event.getY() - lastY;

            // Перемещение графика при перетаскивании
            minX -= deltaX / 50.0;
            maxX -= deltaX / 50.0;
            minY += deltaY / 50.0;
            maxY += deltaY / 50.0;

            // Обновление границ осей
            xAxis.setLowerBound(minX);
            xAxis.setUpperBound(maxX);
            yAxis.setLowerBound(minY);
            yAxis.setUpperBound(maxY);

            lastX = event.getX();
            lastY = event.getY();
        }
    }

    @Override
    protected void handleMouseClick(MouseEvent event, Chart chart) {
        chart.addPoint(event, series, xValues, yValues, xAxis, yAxis);
    }

    @Override
    protected void handleMouseReleased(MouseEvent event) {
        isPanning = false;
    }
}
