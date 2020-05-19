import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task12_17 {
    /**
     * Найти функцию распределения дальности полета снаряда в пустоте, если угол бросания его равномерно распределен
     * в интервале [0;π/2], а ускорение свободного падения постоянно по величине и направлению.
     * */

    private static int limit = 20;
    private static double[] points = new double[30];
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {
        calculate(getRandomIntegerBetweenRange(1, 5));
        calculate(getRandomIntegerBetweenRange(7, 13));
        calculate(getRandomIntegerBetweenRange(15, 20));
        createChart();
    }

    public static void calculate(int v) {
        double g = 9.81;
        int i = 0;
        for (double x = 0.0; x < limit; x+=0.1) {
            if (x >= 0 && x <= Math.PI/2) {
                points[i] = (2/Math.PI)*Math.asin((g*x)/Math.pow(v,2));
            }
            i += 1;
            if (i == points.length) break;
        }
        listOfArrays.add(points.clone());
        listOfNames.add("v = " + v);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("9.13",
                "", listOfArrays, listOfNames, "", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
