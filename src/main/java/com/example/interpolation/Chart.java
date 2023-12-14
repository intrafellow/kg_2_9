package com.example.interpolation;

import com.example.interpolation.math.InterpolatingLagrangePolynomial;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class Chart {
    private void recalculateAndRedrawGraph(XYChart.Series<Number, Number> series, List<Double> xValues, List<Double> yValues) {
        // Очистите старые данные
        series.getData().clear();

        // Повторно вычислите и добавьте данные
        InterpolatingLagrangePolynomial polynomial = new InterpolatingLagrangePolynomial();
        for (double i = 0.0; i <= 10; i += 0.01) {
            XYChart.Data<Number, Number> dataPoint = new XYChart.Data<>(i, polynomial.calculate(xValues, yValues, i));
            Circle circle = new Circle(1.0);
            dataPoint.setNode(circle);
            series.getData().add(dataPoint);
        }
    }

    public void addPoint(MouseEvent event, XYChart.Series<Number, Number> series, List<Double> xValues, List<Double> yValues, NumberAxis xAxis, NumberAxis yAxis) {
        System.out.println(xValues.toString() + " " + yValues.toString());
        double x = xAxis.getValueForDisplay(event.getX()).doubleValue();
        double y = yAxis.getValueForDisplay(event.getY()).doubleValue();

        XYChart.Data<Number, Number> clickedDataPoint = new XYChart.Data<>(x, y);
        Circle circle = new Circle(5.0);
        circle.setFill(Color.RED);
        clickedDataPoint.setNode(circle);

        series.getData().add(clickedDataPoint);
        xValues.add(x - 1.57);
        yValues.add(y + (0.38));
        System.out.println(x - 1.57 + " " + (y  + 0.38));

        recalculateAndRedrawGraph(series, xValues, yValues);
    }
}
