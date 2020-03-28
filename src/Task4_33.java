import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task4_33 {
    /**
     * В очереди за билетами стоимостью 5 руб. стоят n+m человек, из которых n лиц имеют деньги
     * пятирублевого достоинства, а m (m ≤ n + 1) – десятирублевого. Каждый покупает только 1 билет.
     * В кассе до продажи билетов денег нет. Какова вероятность, что никому из очереди не придется ожидать сдачи?
     **/

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 100;
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static int[] arrNs = new int[] {50, 20, 33, 84};
    private static int[] arrMs = new int[] {45, 5, 1, 67};
    private static String[] arrNames = new String[arrNs.length];

    public static void solve() {
        System.out.println("________________________4.33__________________________");
        for (int i = 0; i < arrNs.length; i++) {
            arrNames[i] = "n=" + arrNs[i] + "; m=" + arrMs[i] + "   ";
            calculate(arrNs[i], arrMs[i]);
        }

        createChart();

        System.out.println("______________________________________________________");
    }

    private static void calculate(int entryN, int entryM) {
        int n = entryN;
        int m = entryM;
        double[] arrProb = new double[numberOfExperiments];
        int numberOfValidSituations = 0;
        boolean isValid = false;
        List<Character> charList = new ArrayList<>();
        System.out.println("n = " + n + "; m = " + m);
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            System.out.println("Experiment " + experiment + ": n = " + n + "; m = " + m);
            for (int i = 0; i < n; i++) charList.add('n');
            for (int i = 0; i < m; i++) charList.add('m');
            for (int situation = 0; situation < numberOfSituations; situation++) {
                isValid = false;
                Collections.shuffle(charList);
                if (charList.get(0) == 'n') {
                    numberOfValidSituations++;
                    isValid = true;
                }
                System.out.println(isValid);
            }
            arrProb[experiment] = (double) numberOfValidSituations / numberOfSituations;
        }
        listOfArrays.add(arrProb);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chartA = new XYLineChart_AWT("4.33",
                "", listOfArrays, arrNames, "Номер эксперимента", "Вероятность");
        chartA.createAllInOneDataSet(listOfArrays, arrNames);
        chartA.pack();
        RefineryUtilities.centerFrameOnScreen(chartA);
        chartA.setVisible(true);
    }
}
