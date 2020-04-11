import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task9_13 {

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 100;

    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {

        calculate(8);
        calculate(16);
        calculate(20);
        calculate(5);

        createChart();
    }

    public static void calculate(int roundCounter) {
        listOfNames.add("n=" + roundCounter);
        int numberOfValidSituations = 0;
        double[] array = new double[numberOfExperiments];

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                int winCntPlayer1 = 0;
                int winCntPlayer2 = 0;
                for (int i = 0; i < roundCounter; i++) {
                    if (roundCounter >= 11) {
                        if (    (winCntPlayer1 >= 6 || winCntPlayer2 >= 6) &&
                                Math.abs(winCntPlayer1 - winCntPlayer2) >= 2) break;
                    }
                    int round = getRandomIntegerBetweenRange(0, 1);
                    if (round == 1) winCntPlayer1++;
                    else winCntPlayer2++;
                }
                if (Math.abs(winCntPlayer1 - winCntPlayer2) >= 2 &&
                    winCntPlayer1 + winCntPlayer2 == roundCounter) numberOfValidSituations++;
            }
            array[experiment] = (double) numberOfValidSituations / numberOfSituations;
        }
        listOfArrays.add(array);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("9.13",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
