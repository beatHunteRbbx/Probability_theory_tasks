import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task14_11 {

    /**
     * Производится два независимых измерения прибором, ошибки измерения которого X имеют
     * x̅= 10 м и σ=30 м. Какова вероятность того, что каждая из ошибок измерения, имея разные знаки,
     * по абсолютной величине превзойдет 10 м?
     * */

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 100000;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();

    public static void solve() {
        calculate(10);
        createChart();
    }

    private static void calculate(int limit) {
        int numberOfValidSituations;
        double[] array = new double[numberOfExperiments];
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                //для генерации случайных величин использовалось преобразование Бокса-Мюллера
                double r = getRandomIntegerBetweenRange(0,1);
                double fi = getRandomIntegerBetweenRange(0,1);

                double y0 = Math.cos(2*Math.PI*fi)*Math.sqrt(-2*Math.log(r));
                double y1 = Math.sin(2*Math.PI*fi)*Math.sqrt(-2*Math.log(r));

                if (Math.abs(y0) > limit && Math.abs(y1) > limit) numberOfValidSituations++;
            }
            array[experiment] = (double) numberOfValidSituations / numberOfSituations;
        }
        listOfArrays.add(array);
        double sum = 0.0;
        for (double prob : array) {
            sum += prob;
        }
        listOfNames.add("средн.вер.=" + sum / (double) array.length + " (limit=" + limit + ")");
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("13.39",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
