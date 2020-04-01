import org.jfree.ui.RefineryUtilities;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Task8_8 {

    /**
     * Вероятность того, что агрегат необходимо поставить на ремонт после m аварий, определяется
     * формулой G(m)=1-(1-1/ω)^m, где ω – среднее число аварий до постановки агрегата на ремонт.
     * Доказать, что вероятность того, что после n производственных циклов потребуется ремонт,
     * определяется по формуле W_n=1-(1-p/ω)^n, где  p – вероятность того, что во время одного
     * производственного цикла произойдет авария.
     * */

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 1000;
    private static int numberOfValidSituations = 0;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] array = new double[numberOfExperiments];

    public static void solve() {

        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                calculate(  getRandomIntegerBetweenRange(1, 10),
                            getRandomIntegerBetweenRange(1, 10),
                            getRandomIntegerBetweenRange(1, 2),
                            getRandomDoubleBetweenRange(0, 1.0));
            }
            array[experiment] = (double) numberOfValidSituations / numberOfSituations;
            System.out.println(experiment + ": " + numberOfValidSituations);
        }
        createChart();
    }

    private static void calculate(int entryN, int entryM, int entryOmega, double entryP) {
        int n = entryN;
        int m = entryM;
        int omega = entryOmega;
        double p = entryP;
        double q = 1 - p;

        double R_nm = 0;
        for (int i = 1; i <= n; i++) {
            double C = (double) (factorial(n) / (factorial(n - i) * factorial(i)));
            R_nm += C * Math.pow(p, i) * Math.pow(q, n - i);
        }

        double G_m = 1 - Math.pow(1 - (double) 1 / omega, m);

        double experimentalAnswer = R_nm * G_m;
        double formulaAnswer = 1 - Math.pow(1 - p / omega, n);

        if (Math.abs(experimentalAnswer - formulaAnswer) <= 0.05) {
            numberOfValidSituations++;
        }
    }

    private static int factorial(int numb) {
        int fact = 1;
        for (int i = 1; i <= numb; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("8.8",
                "", array, "", "Номер эксперимента", "Вероятность");
        chart.createDataSet(array, "");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

}
