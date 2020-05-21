import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task15_10 {

    /**
     * Случайная величина X подчиняется закону Пуассона
     *              P(X=m)=(a^m/m!)*e^(-a),
     * параметр которого неизвестен, но имеет до опыта плотность вероятности
     *              f(a)=a*e^(-a)      (a>0).
     * Произведён опыт, в результате которого случайная величина X приняла значение m_0.
     * Найти плотность вероятности a после опыта.
     * */

    private static double[] points = new double[150];
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {
        for (int i = 0; i < 3; i++) {
            calculate(getRandomIntegerBetweenRange(1, 10));
        }
        createChart();
    }

    private static void calculate(double m0) {
        int i = 0;
        for (double a = 0.0; i < points.length; a += 0.1) {
            points[i] = (2*Math.pow(2*a, m0+1)*Math.exp(-2*a))/factorial(m0 + 1);
            i++;
        }
        listOfArrays.add(points.clone());
        listOfNames.add("m0=" + m0);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static int factorial(double numb) {
        int fact = 1;
        for (int i = 1; i <= numb; i++) {
            fact *= i;
        }
        return fact;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("15.10",
                "", listOfArrays, listOfNames, "y", "x");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
