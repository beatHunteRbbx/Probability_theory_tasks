import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task13_39 {

    private static double[] points = new double[300];
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {
        for (int i = 0; i < 3; i++) {
            calculate(  getRandomIntegerBetweenRange(1, 10),
                        getRandomIntegerBetweenRange(1, 10));
        }


        createChart();

    }

    public static void calculate(int a, int beta) {
        int i = 0;
        for (double x = 0.1; i < points.length; x += 0.1) {
            points[i] = Math.exp(-Math.abs(x-a)/beta);
            i++;
        }
        listOfArrays.add(points.clone());
        listOfNames.add("a=" + a + "; β=" + beta);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("13.39",
                "", listOfArrays, listOfNames, "x", "y");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
