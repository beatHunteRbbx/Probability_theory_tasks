import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task12_17 {
    /**
     * Найти функцию распределения дальности полета снаряда в пустоте, если угол бросания его равномерно распределен
     * в интервале [0;π/2], а ускорение свободного падения постоянно по величине и направлению.
     * */

    private static ArrayList<Double> arrX = new ArrayList<>();
    private static ArrayList<Double> arrY = new ArrayList<>();
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArraysX = new ArrayList<>();
    private static ArrayList<double[]> listOfArraysY = new ArrayList<>();

    public static void solve() {
        for (int i = 0 ; i < 3; i++) {
            calculate(getRandomIntegerBetweenRange(1, 15));
        }

        createChart();
    }

    public static void calculate(double v) {
        arrX.clear();
        arrY.clear();
        double g = 9.81;

        double x = 0.0;
        double y = 0.0;
        do {
            double angle = (g * x) / Math.pow(v, 2);
            y = (2 / Math.PI) * Math.asin(angle);
            arrX.add(x);
            arrY.add(y);
            x += 0.01;
        } while (y <= 1);
        double[] arrayX = new double[arrX.size()];
        double[] arrayY = new double[arrX.size()];
        for (int i = 0; i < arrX.size(); i++) {
            arrayX[i] = arrX.get(i);
            arrayY[i] = arrY.get(i);
        }
        listOfArraysX.add(arrayX.clone());
        listOfArraysY.add(arrayY.clone());
        listOfNames.add("v = " + v);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("12.17",
                "", listOfArraysX, listOfArraysY, listOfNames, "x", "y");
        chart.createXYDataSet(listOfArraysX, listOfArraysY, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
