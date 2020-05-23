import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task10_8 {

    /**
     * Имеется n заготовок для одной и той же детали. Вероятность изготовления годной детали из каждой заготовки равна p.
     * Найти ряды распределения и производящие функции для:
     *      а) числа заготовок, оставшихся после изготовления годной детали
     *      б) числа использованных заготовок
     * */

    static int n = getRandomIntegerBetweenRange(20, 40);
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] arrayA = new double[n];
    private static double[] arrayB = new double[n];

    public static void solve() {
        calculate(n);
        createChart();
    }

    private static void calculate(int n) {
        double p = getRandomDoubleBetweenRange(0, 1);
        double q = 1 - p;

        for (int k = 1; k <= n; k++) {
            arrayA[k - 1] = Math.pow(q, n-k-1) * p;
            if (k >= 1 && k <= n - 1) arrayB[k - 1] = Math.pow(q, k - 1) * p;
            if (k == n) arrayB[k - 1] = Math.pow(q, n - 1);
        }

        listOfArrays.add(arrayA.clone());
        listOfNames.add("а) n=" + n);
        listOfArrays.add(arrayB.clone());
        listOfNames.add("б) n=" + n);

        for (double element : arrayA) System.out.print(element + " ");
        System.out.println();
        for (double element : arrayB) System.out.print(element + " ");
    }

    private static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)))+min;
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("10.8",
                "", listOfArrays, listOfNames, "Количество изделий", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
