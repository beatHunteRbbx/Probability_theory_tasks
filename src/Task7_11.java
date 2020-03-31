import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collections;

public class Task7_11 {

    private static int numberOfExperiments = 20;
    private static int numberOfSituations = 100000;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {

//            calculate(3,2);
        for (int i = 0; i < 2; i++) {
            int n = getRandomIntegerBetweenRange(5, 20);
            int k = getRandomIntegerBetweenRange(5, n);
            calculate(n, k);
        }
        calculate(  getRandomIntegerBetweenRange(5, 15),
                    getRandomIntegerBetweenRange(15, 20));
        createChart();


    }

    private static void calculate(int entryN, int entryK) {
        int n = entryN;
        int k = entryK;

        String chartName = "n=" + n + " k=" + k +"       ";
        listOfNames.add(chartName);
        int numberOfValidSituations = 0;

        ArrayList<Integer> trash = new ArrayList<>();

        ArrayList<Integer> extractedBallsList = new ArrayList<>();
        double[] arrProb = new double[numberOfExperiments];

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            trash.clear();
            n = entryN;
            int rnd = getRandomIntegerBetweenRange(1, n);
            for (int i = 0; i < rnd; i++) {
                trash.add(0);    // 0 - белый шар
                n--;
            }
            for (int i = 0; i < n; i++) trash.add(1);  // 1 - шары других цветов (не белые)

            numberOfValidSituations = 0;
            Collections.shuffle(trash);
            extractedBallsList.clear();
            for (int situation = 0; situation < numberOfSituations; situation++) {
                extractedBallsList.clear();
                Collections.shuffle(trash);
                for (int i = 0; i < k; i++) {
                    int rndNumb = getRandomIntegerBetweenRange(0, entryN - 1);
                    Integer ball = trash.get(rndNumb);
                    extractedBallsList.add(ball);
                }
                if (!extractedBallsList.contains(1)) numberOfValidSituations++;
            }
            arrProb[experiment] = (double) numberOfValidSituations / numberOfSituations;
            System.out.println("Exp " + experiment + ": prob = " + arrProb[experiment]);
        }
        listOfArrays.add(arrProb);

        double sum = 0;
        for (double prob : arrProb) {
            sum += prob;
        }
        System.out.println("avr. prob = " + sum / (double) arrProb.length);
        System.out.println();
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("7.11",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
