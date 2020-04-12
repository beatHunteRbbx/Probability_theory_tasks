import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4_33 {
    /**
     * В очереди за билетами стоимостью 5 руб. стоят n+m человек, из которых n лиц имеют деньги
     * пятирублевого достоинства, а m (m ≤ n + 1) – десятирублевого. Каждый покупает только 1 билет.
     * В кассе до продажи билетов денег нет. Какова вероятность, что никому из очереди не придется ожидать сдачи?
     **/

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 10000;
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static int[] arrNs = new int[] {50, 20, 33, 84};
    private static int[] arrMs = new int[] {45, 5, 1, 67};
    private static ArrayList<String> listOfNames = new ArrayList<>();

    public static void solve() {

        for (int i = 0; i < arrNs.length; i++) calculate(arrNs[i], arrMs[i]);

        createChart();
    }

    private static void calculate(int entryN, int entryM) {
        int n = entryN;
        int m = entryM;
        double[] arrProb = new double[numberOfExperiments];
        int numberOfValidSituations = 0;
        List<Character> charList = new ArrayList<>();
        System.out.println("n = " + n + "; m = " + m);
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            for (int i = 0; i < n; i++) charList.add('n');
            for (int i = 0; i < m; i++) charList.add('m');
            for (int situation = 0; situation < numberOfSituations; situation++) {
                Collections.shuffle(charList);
                int cash = 0;
                boolean isValid = true;
                for (char member : charList) {
                    if (member == 'n') cash += 5;
                    else cash -= 5;
                    if (cash < 0) isValid = false;
                }
                if (isValid) numberOfValidSituations++;
            }
            arrProb[experiment] = (double) numberOfValidSituations / numberOfSituations;
        }
        listOfArrays.add(arrProb);
        double sum = 0;
        for (double prob : arrProb) sum += prob;
        listOfNames.add("n=" + n + "; m=" + m + "   " + "     средн.вер. = " + sum / arrProb.length);
    }

    private static void createChart() {
        XYLineChart_AWT chartA = new XYLineChart_AWT("4.33",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chartA.createAllInOneDataSet(listOfArrays, listOfNames);
        chartA.pack();
        RefineryUtilities.centerFrameOnScreen(chartA);
        chartA.setVisible(true);
    }
}
