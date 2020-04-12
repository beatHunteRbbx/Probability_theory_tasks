import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task3_9 {
    /**
     * На отрезке длинной l независимо одна от другой поставлены две точки,
     * положение каждой из которых равновозможно на всем отрезке.
     * Определить вероятность того, что расстояние между этими точками меньше βl, где 0 <β<1.
     * */

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 10000;
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] arrBetas = new double[] {0.2, 0.5, 0.6, 0.9};
    private static ArrayList<String> listOfNames= new ArrayList<>();

    public static void solve() {

        calculate(arrBetas[0]);
        calculate(arrBetas[1]);
        calculate(arrBetas[2]);
        calculate(arrBetas[3]);

        createChart();
    }

    private static void calculate(double entryBeta) {
        System.out.println("β = " + entryBeta);
        double l;
        double p1;
        double p2;
        double beta = entryBeta;
        double lengthBetweenPoints;
        double requireLength;
        int numberOfValidSituations = 0;
        double[] arrProbability = new double[numberOfExperiments];

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            System.out.print("  Experiment " + experiment + ": ");
            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                l = 10;
                p1 = getRandomDoubleBetweenRange(0.0, 10.0);
                p2 = getRandomDoubleBetweenRange(0.0, 10.0);
                lengthBetweenPoints = Math.abs(p2 - p1);
                requireLength = beta * l;
                if (lengthBetweenPoints < requireLength) {
                    numberOfValidSituations++;
                }
            }

            arrProbability[experiment] = (double) numberOfValidSituations / numberOfSituations;
            System.out.println("Average probability = " + arrProbability[experiment]);
        }
        listOfArrays.add(arrProbability);
        double sum = 0;
        for (double prob : arrProbability) sum += prob;
        listOfNames.add("β=" + entryBeta + "     средн.вер. = " + sum / arrProbability.length);
        System.out.println();
    }

    private static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("3.9",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
