import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collections;

public class Task6_4 {
    /**
     * Имеется n урн, в каждой из которых по m белых и по k черных шаров. Из первой урны
     * наудачу извлекается один шар и перекладывается во вторую. Затем из второй урны наудачу
     * извлекается один шар и перекладывается в третью урну и т.д.
     * Определить вероятность извлечения после такого перекладывания белого шара из последней урны.
     * */

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 500;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();


    public static void solve() {

            for (int i = 0; i < 3; i++) {
                calculate(  getRandomIntegerBetweenRange(1, 20),
                            getRandomIntegerBetweenRange(1, 100),
                            getRandomIntegerBetweenRange(1, 100));
            }
            createChart();
    }

    private static void calculate(int entryN, int entryM, int entryK) {
        int n = entryN;
        int m = entryM;
        int k = entryK;
        String chartName = "n=" + n + " m=" + m + " k=" + k +"; ";
        listOfNames.add(chartName);

        ArrayList<String> trash = new ArrayList<>();
        ArrayList<ArrayList<String>> arrTrashes = new ArrayList<>();

        for (int i = 0; i < m; i++) trash.add("white");
        for (int i = 0; i < k; i++) trash.add("black");
        for (int i = 0; i < n; i++) arrTrashes.add(new ArrayList<>(trash));

        int numberOfValidSituations = 0;
        double[] arrProb = new double[numberOfExperiments];

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            //в начале каждого нового эксперимента перемешиваем все урны
            for (ArrayList localTrash : arrTrashes) Collections.shuffle(localTrash);

            for (int situation = 0; situation < numberOfSituations; situation++) {
                for (int trashNumb = 0; trashNumb < n - 1; trashNumb++) {
                    int rnd = getRandomIntegerBetweenRange(0, m + k - 1);
                    String ball = arrTrashes.get(trashNumb).get(rnd);
                    arrTrashes.get(trashNumb).remove(rnd);
                    arrTrashes.get(trashNumb + 1).add(ball);
                }
                int rnd = getRandomIntegerBetweenRange(0, m + k - 1);
                String lastBall = arrTrashes.get(arrTrashes.size() - 1).get(rnd);
                arrTrashes.get(arrTrashes.size() - 1).remove(rnd);
                arrTrashes.get(0).add(lastBall);
                if (lastBall.equals("white")) numberOfValidSituations++;
            }
            arrProb[experiment] = (float) numberOfValidSituations / numberOfSituations;
        }
        listOfArrays.add(arrProb);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("6.4",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
