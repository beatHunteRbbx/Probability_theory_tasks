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
    private static double[] arrayPoisson = new double[numberOfExperiments];
    private static double[] arrayCalls = new double[numberOfExperiments];

    public static void solve() {
        calculate();
        createChart();
    }

    private static void calculate() {
        double lambda = 0.5;
        int counter = 0;
        for (int k = 0; k < numberOfExperiments; k++) {
            arrayPoisson[k] = (Math.pow(lambda, k) * Math.exp(-lambda))/factorial(k);
            arrayCalls[k] = lambda * Math.exp(-lambda*k);
            if (arrayCalls[k] > arrayPoisson[k]) counter++;
        }
        System.out.println("Количество раз, когда время больше 30 секунд = " + counter);
        listOfArrays.add(arrayPoisson);
        listOfNames.add("Вероятность по ф.Пуассона (λ = " + lambda + ")");
        listOfArrays.add(arrayCalls);
        listOfNames.add("Распределение вызовов (λ = " + lambda + ")");
    }

    private static int factorial(int numb) {
        int fact = 1;
        for (int i = 1; i <= numb; i++) {
            fact *= i;
        }
        return fact;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("11.34",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
