import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Task19_37 {

    /**
     * Найти математическое ожидание и дисперсию случайной величины Z=min(X,Y),
     * если X,Y – независимые случайные величины, плотности которых заданы.
     * */

    private static int numberOfExperiments = 20;
    private static ArrayList<String> listOfNames = new ArrayList<>();
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static double[] arrayX = new double[numberOfExperiments];
    private static double[] arrayY = new double[numberOfExperiments];
    private static double[] arrayZ = new double[numberOfExperiments];

    private static double lambda = getRandomDoubleBetweenRange(0, 1);
    private static double sigma = getRandomDoubleBetweenRange(0, 3);
    private static double a = getRandomIntegerBetweenRange(1, 15);

    public static void solve() {
        calculate();
        createChart();
    }

    private static void calculate() {
        for (int arg = 0; arg < numberOfExperiments; arg++) {
            //величина X - экспоненциальное распределение
            arrayX[arg] = Fx(arg);
            //величина Y - нормальное (гауссовское) распределение
            arrayY[arg] = Fy(arg);

            arrayZ[arg] = min(arrayX[arg], arrayY[arg]);
        }

        //определяем начальные моменты СВ Z:
        // 1ый - M[Z] - мат ожидание Z (среднее арифметическое)
        // 2ой - M[Z^2]
        double sumFirstMoment = 0;
        double sumSecondMoment = 0;
        for (double element : arrayZ) {
            sumFirstMoment += element;
            sumSecondMoment += Math.pow(element, 2);
        }
        double mZFirstMoment = sumFirstMoment / arrayZ.length;
        double mZSecondMoment = sumSecondMoment / arrayZ.length;

        System.out.println("Начальные моменты СВ Z:");
        System.out.print("    1ый (мат. ожидание M[Z]): ");
        System.out.println(String.format("%.8f", mZFirstMoment));
        System.out.print("    2ой (M[Z^2]): ");
        System.out.println(String.format("%.8f", mZSecondMoment));

        //вычисляем дисперсию СВ Z: D[Z]=M[Z^2]-M[Z]^2
        double D = mZSecondMoment-Math.pow(mZFirstMoment, 2);
        System.out.print("Дисперсия СВ Z: ");
        System.out.println(String.format("%.8f", D));


        listOfArrays.add(arrayX.clone());
        listOfNames.add("E: λ=" + lambda);
        listOfArrays.add(arrayY.clone());
        listOfNames.add("N: a=" + a + ", σ=" + sigma);
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }


    private static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)))+min;
    }

    private static double Fx(double arg) {
        return 1 - Math.exp(-lambda*arg);
    }

    private static double Fy(double arg) {
        return 1/(Math.sqrt(2*Math.PI)*sigma)*Math.exp(-(Math.pow(arg-a,2))/(2*Math.pow(sigma,2)));
    }

    private static double min(double numb1, double numb2) {
        return numb1 < numb2 ? numb1 : numb2;
    }

    private static void createChart() {
        XYLineChart_AWT chart = new XYLineChart_AWT("15.10",
                "", listOfArrays, listOfNames, "x", "y");
        chart.createAllInOneDataSet(listOfArrays, listOfNames);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
