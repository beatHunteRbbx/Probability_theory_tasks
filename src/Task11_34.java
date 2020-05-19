import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task11_34 {
    /**
     * Считая число вызовов, поступающих на коммутатор за заданный промежуток времени случайной величиной,
     * подчиняющейся закону Пуассона с параметром, пропорциональным длине промежутка, определить вероятность того,
     * что за 30 сек не будет ни одного вызова, если математическое ожидание числа вызовов за час равно 60.
     * */

    private static int numberOfExperiments = 30;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] array = new double[numberOfExperiments];

    public static void solve() {
        calculate();
        createChart();
    }

    private static void calculate() {
        double lambda = 0.5;
        for (int k = 0; k < numberOfExperiments; k++) {
            array[k] = (Math.pow(lambda, k) * Math.exp(-lambda))/factorial(k);
        }
        listOfArrays.add(array);
        listOfNames.add("lambda = " + lambda);
    }

    private static int factorial(int numb) {
        int fact = 1;
        for (int i = 1; i <= numb; i++) {
            fact *= i;
        }
        return fact;
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
