import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collections;

public class Task7_11 {
    /**
     * В урне имеется n шаров; до опытов любое предположение о числе белых шаров среди них равновероятно.
     * Извлекаются последовательно k шаров, причем каждый раз после извлечения шар возвращается в урну.
     * Какова вероятность того, что в урне содержатся только белые шары, если шары другого цвета не извлекались.
     * */

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 100000;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {
        for (int i = 0; i < 3; i++) {
            int n = getRandomIntegerBetweenRange(1, 30);
            int k = getRandomIntegerBetweenRange(1, n);
            calculate(n, k);
        }
        createChart();
    }

    private static void calculate(int n, int k) {

        int numberOfValidSituations;

        ArrayList<Integer> trash = new ArrayList<>();
        ArrayList<Integer> extractedBallsList = new ArrayList<>();
        double[] arrProb = new double[numberOfExperiments];

        //заполняем урну:
        //  0 - шар белого цвета
        //  1 - шар не белого цвета
        for (int i = 0; i < n; i++) trash.add(getRandomIntegerBetweenRange(0,1));

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            Collections.shuffle(trash);
            for (int situation = 0; situation < numberOfSituations; situation++) {
                extractedBallsList.clear();
                for (int i = 0; i < k; i++) {
                    int rndNumb = getRandomIntegerBetweenRange(0, trash.size() - 1);
                    Integer ball = trash.get(rndNumb);
                    extractedBallsList.add(ball);
                }
                if (!extractedBallsList.contains(1)) numberOfValidSituations++;
            }
            arrProb[experiment] = (double) numberOfValidSituations / numberOfSituations;
        }

        System.out.println("trash: "+ trash);
        double sum = 0;
        for (double prob : arrProb) {
            sum += prob;
        }
        listOfNames.add("n=" + n + " k=" + k +"  средн.вер.=" + sum / (double) arrProb.length);
        System.out.println("avr. prob = " + sum / (double) arrProb.length);

        //формульный ответ (аналитический)
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(i + 1, k);
        }
        System.out.println("formula=" + Math.pow(n,k) / sum);
        System.out.println();

        listOfArrays.add(arrProb);
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
