import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collections;

public class Task5_20 {
    /**
     * Из урны, содержащей n шаров с номерами от 1 до n, последовательно извлекают два шара,
     * причем первый шар возвращается, если его номер не равен единице.
     * Определить вероятность того, что шар с номером 2 будет извлечен при втором извлечении.
     * */

    private static int numberOfExperiments = 20;
    private static int numberOfSituations = 1000;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();


    public static void solve() {

        calculate(getRandomIntegerBetweenRange(1, 20));
        calculate(getRandomIntegerBetweenRange(30, 60));
        calculate(getRandomIntegerBetweenRange(80, 120));

        createChart();

    }
    private static void calculate(int numb) {
        int numberOfValidSituations = 0;
        String chartName = "";
        double[] arrProb = new double[numberOfExperiments];
        ArrayList<Integer> trash = new ArrayList<>();

        double[] array = new double[numberOfExperiments];
        int n = numb;
        chartName = "n = " + n;
        listOfNames.add(chartName);
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {

            for (int i = 0; i < n; i++) trash.add(i + 1);



            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                Collections.shuffle(trash);

                //извлечение 1ого шара
                int rndNumb1 = getRandomIntegerBetweenRange(0, n - 1);
                int firstBall = trash.get(rndNumb1);
                trash.remove(rndNumb1);
                if (firstBall != 1) trash.add(firstBall);

                //извлечение 2ого шара
                int rndNumb2 = getRandomIntegerBetweenRange(0, n - 1);
                int secondBall = trash.get(rndNumb2);
                trash.remove(rndNumb2);
                if (secondBall == 2) numberOfValidSituations++;

                if (!trash.contains(firstBall)) trash.add(firstBall);
                trash.add(secondBall);
            }
            arrProb[experiment] = (double) numberOfValidSituations / numberOfSituations;
            array = arrProb.clone();


        }
        listOfArrays.add(array);
    }


    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("5.20",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
