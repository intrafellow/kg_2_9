package com.example.interpolation.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InterpolatingLagrangePolynomial {
    //test
    public static void main(String[] args) {
        double[] xValues = new double[]{0, 2, 3, 5};
        double[] yValues = new double[]{0, 1, 3, 2};

        Function<Double, Double> ilp = new InterpolatingLagrangePolynomial().createLagrangePolynomial(xValues, yValues);
        System.out.println(ilp.apply(4.6));
    }

    public double calculate(List<Double> xValues, List<Double> yValues, double x){
        return createLagrangePolynomial(xValues.stream().mapToDouble(Double::doubleValue).toArray(),
                yValues.stream().mapToDouble(Double::doubleValue).toArray()).apply(x);
    }

    // Calculate basic pol
    private Function<Double, Double> createBasicPolynomial(double[] xValues, int i){
        Function<Double, Double> basicPolynomial = (x) -> {
            double divider = 1;
            double result = 1;
            // calc l_i for each point
            for (int j = 0; j < xValues.length; j++) {
                if(j != i){
                    result *= x - xValues[j];
                    divider *= xValues[i] - xValues[j];
                }
            }
            return result / divider;
        };
        return basicPolynomial;
    }

    private Function<Double, Double> createLagrangePolynomial(double[] xValues, double[] yValues){
        List<Function<Double, Double>> basicPolynomial = new ArrayList<>();
        for (int i = 0; i < xValues.length; i++) {
            basicPolynomial.add(createBasicPolynomial(xValues, i));
        }
        Function<Double, Double> lagrangePolynomial = (x) -> {
            double result = 0;
            for (int i = 0; i < xValues.length; i++) {
                result+=yValues[i] * basicPolynomial.get(i).apply(x);
            }
            return result;
        };
        return lagrangePolynomial;
    }
}
