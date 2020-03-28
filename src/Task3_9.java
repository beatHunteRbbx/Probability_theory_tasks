import org.jfree.ui.RefineryUtilities;

public class Task3_9 {

    private static int numberOfExperiments = 10;
    private static int numberOfSituations = 20;
    private static double[] array = new double[numberOfExperiments];

    public static void solve() {

        double l;
        double p1;
        double p2;
        double beta;
        double lengthBetweenPoints;
        double requireLength;
        boolean isValid;
        int numberOfValidSituations = 0;
        double[] probability = new double[numberOfExperiments];

        System.out.println("________________________3.9__________________________");
        System.out.println();
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            System.out.println("Experiment " + experiment + ": ");
            numberOfValidSituations = 0;
            for (int situation = 0; situation < numberOfSituations; situation++) {
                isValid = false;
                l = 10;
                p1 = getRandomDoubleBetweenRange(0.0, 10.0);
                p2 = getRandomDoubleBetweenRange(0.0, 10.0);
                beta = getRandomDoubleBetweenRange(0.0, 1.0);
                lengthBetweenPoints = Math.abs(p2 - p1);
                requireLength = beta * l;
                if (lengthBetweenPoints < requireLength) {
                    numberOfValidSituations++;
                    isValid = true;
                }

                System.out.println(   "  Situation " + situation +
                                    ": point_1=" + p1 +
                                    "; point_2=" + p2 +
                                    "; l=" + l +
                                    "; β=" + beta +
                                    "          " +
                                    "valid=" + isValid);
            }

            probability[experiment] = (double) numberOfValidSituations / numberOfSituations;
            System.out.println("Average probability = " + probability[experiment]);
            System.out.println();
        }
        System.out.println("______________________________________________________");
        System.out.println();
        System.out.println();
        array = probability.clone();

        createChart();
    }

    private static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)))+min;
    }

    private static void createChart() {
        XYLineChart_AWT chartA = new XYLineChart_AWT("3.9",
                "", array, "вероятность подходящих ситуаций", "Номер эксперимента", "Вероятность");
        chartA.createDataSet(array, "вероятность подходящих ситуаций");
        chartA.pack();
        RefineryUtilities.centerFrameOnScreen(chartA);
        chartA.setVisible(true);
    }
}
