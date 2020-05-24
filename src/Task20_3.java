import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Random;

public class Task20_3 {

    /**
     * Найти плотность вероятности f(x) случайной величины Z=aX^2,
     * если X – нормальная случайная величина, x ̅=0,D[X]=σ^2,a>0.
     * */

    private static int numberOfExperiments = 20;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] arrayX = new double[numberOfExperiments];
    private static double[] arrayZ = new double[numberOfExperiments];
    private static double[] arrDensityZ = new double[numberOfExperiments];

    public static void solve() {
        calculate(10, 5);
        createChart();
    }

    private static void calculate(double a, double sigma) {
        for (int x = 0; x < numberOfExperiments; x++) {
            arrayX[x] = 1 / (Math.sqrt(2 * Math.PI) * sigma) * Math.exp(-Math.pow(x - a, 2) / (2 * Math.pow(sigma, 2)));
            arrayZ[x] = a * Math.pow(arrayX[x], 2);
            if (arrayZ[x] >= 0) {
                arrDensityZ[x] = (1/(Math.sqrt(2*Math.PI*a*arrayZ[x])*sigma))*Math.exp(-(arrayZ[x]/(2*Math.pow(sigma,2)*a)));
            }
            else arrDensityZ[x] = 0;
        }
        listOfArrays.add(arrayX.clone());
        listOfNames.add("X");
        listOfArrays.add(arrayZ.clone());
        listOfNames.add("Z");
        listOfArrays.add(arrDensityZ.clone());
        listOfNames.add("Плотность Z");
    }


    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("20.3",
                "", listOfArrays, listOfNames, "x", "y");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
