import org.jfree.ui.RefineryUtilities;

public class Task2_10 {
/**
 * Известно, что все номера автомашины четырёхзначные, начиная с 0001, не повторяющиеся и равновозможные.
 * Определить вероятность того, что номер первой встретившейся автомашины:
 * a) не содержит одинаковых цифр
 * б) имеет две одинаковые цифры
 * в) имеет три одинаковые цифры
 * г) содержит две пары одинаковых цифр
 * д) состоит из одинаковых цифр
 * */
    private static int size = 10;
    private static double[] arrayA = new double[size];
    private static double[] arrayB = new double[size];
    private static double[] arrayC = new double[size];
    private static double[] arrayD = new double[size];
    private static double[] arrayE = new double[size];


    private static int getRandomIntegerBetweenRange(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    private static int[][] createArrayOfNumbers(int size) {
        int[][] numbers = new int[size][4];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = getRandomIntegerBetweenRange(0, 9);
            }
        }
        return numbers;
    }

    public static void solve() {
        int numberOfExperiments = 10;
        int amountOfValidNumbers;
        int[][] numbers;
        double[] probability = new double[numberOfExperiments];
        double sum = 0.0;

        System.out.println("________________________2.10__________________________");

        //пункт a)
        System.out.println("A)");
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (    numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][2] && numbers[i][0] != numbers[i][3] &&
                        numbers[i][1] != numbers[i][2] &&
                        numbers[i][2] != numbers[i][3]) amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / size;

            System.out.println("       probability = " + (double) amountOfValidNumbers/size);
        }
        System.out.println();
        arrayA = probability.clone();
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт б)
        System.out.println("Б)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (    (numbers[i][0] == numbers[i][1] && numbers[i][0] != numbers[i][2] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][2] && numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][2]) ||
                        (numbers[i][1] == numbers[i][2] && numbers[i][1] != numbers[i][0] && numbers[i][1] != numbers[i][3]) ||
                        (numbers[i][1] == numbers[i][3] && numbers[i][1] != numbers[i][0] && numbers[i][0] != numbers[i][2]) ||
                        (numbers[i][2] == numbers[i][3] && numbers[i][2] != numbers[i][0] && numbers[i][2] != numbers[i][1])    )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / size;

            System.out.println("       probability = " + (double) amountOfValidNumbers/size);
        }
        System.out.println();
        arrayB = probability.clone();
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of 2 same digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт в)
        System.out.println("В)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (    (numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][2] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][2]) ||
                        (numbers[i][0] == numbers[i][2] && numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][1]) ||
                        (numbers[i][1] == numbers[i][2] && numbers[i][1] == numbers[i][3] && numbers[i][1] != numbers[i][0])    )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / size;

            System.out.println("       probability = " + (double) amountOfValidNumbers/size);
        }
        System.out.println();
        arrayC = probability.clone();
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт г)
        System.out.println("Г)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (    numbers[i][0] == numbers[i][1] && numbers[i][2] == numbers[i][3] && numbers[i][0] != numbers[i][2] ||
                        numbers[i][0] == numbers[i][2] && numbers[i][1] == numbers[i][3] && numbers[i][0] != numbers[i][1] ||
                        numbers[i][0] == numbers[i][3] && numbers[i][1] == numbers[i][2] && numbers[i][0] != numbers[i][1]  )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / size;

            System.out.println("       probability = " + (double) amountOfValidNumbers/size);
        }
        System.out.println();
        arrayD = probability.clone();
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();


        //пункт д)
        System.out.println("Д)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (    numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][2] && numbers[i][0] == numbers[i][3] &&
                        numbers[i][1] == numbers[i][2] &&
                        numbers[i][2] == numbers[i][3] )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / size;

            System.out.println("       probability = " + (double) amountOfValidNumbers/size);
        }
        System.out.println();
        arrayE = probability.clone();
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);

        System.out.println("______________________________________________________");
        System.out.println();
        System.out.println();

        createChart();
    }

    private static void createChart() {
        XYLineChart_AWT chartA = new XYLineChart_AWT("2.10 А",
                "не содержит одинаковых цифр", arrayA, "А", "Номер эксперимента", "Вероятность");
        chartA.createDataSet(arrayA, "2.10 A");
        chartA.pack();
        RefineryUtilities.centerFrameOnScreen( chartA );
        chartA.setVisible(true);

        XYLineChart_AWT chartB = new XYLineChart_AWT("2.10 Б",
                "имеет две одинаковые цифры", arrayB, "Б", "Номер эксперимента", "Вероятность");
        chartB.pack();
        chartB.createDataSet(arrayB, "2.10 Б");
        RefineryUtilities.centerFrameOnScreen( chartB );
        chartB.setVisible(true);

        XYLineChart_AWT chartC = new XYLineChart_AWT("2.10 В",
                "имеет три одинаковые цифры", arrayC, "В", "Номер эксперимента", "Вероятность");
        chartC.pack();
        chartC.createDataSet(arrayC, "2.10 В");
        RefineryUtilities.centerFrameOnScreen( chartC );
        chartC.setVisible(true);

        XYLineChart_AWT chartD = new XYLineChart_AWT("2.10 Г",
                "содержит две пары одинаковых цифр", arrayD, "Г", "Номер эксперимента", "Вероятность");
        chartD.pack();
        chartD.createDataSet(arrayD, "2.10 Г");
        RefineryUtilities.centerFrameOnScreen( chartD );
        chartD.setVisible(true);

        XYLineChart_AWT chartE = new XYLineChart_AWT("2.10 Д",
                "состоит из одинаковых цифр", arrayE, "Д", "Номер эксперимента", "Вероятность");
        chartE.pack();
        chartE.createDataSet(arrayE, "2.10 Д");
        RefineryUtilities.centerFrameOnScreen( chartE );
        chartE.setVisible(true);
    }
}
