import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

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
    private static int numberOfSituations = 10000;
    private static ArrayList<double[]> listOfArrays = new ArrayList<>();
    private static ArrayList<String> listOfNames = new ArrayList<>();


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

        //пункт a)
        System.out.println("A) ");
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfSituations);
            for (int i = 0; i < numberOfSituations; i++) {
                if (    numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][2] && numbers[i][0] != numbers[i][3] &&
                        numbers[i][1] != numbers[i][2] && numbers[i][1] != numbers[i][3] &&
                        numbers[i][2] != numbers[i][3]) amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / numberOfSituations;

            System.out.println("       probability = " + (double) amountOfValidNumbers/ numberOfSituations);
        }
        System.out.println();
        listOfArrays.add(probability.clone());
        for (double prob : probability) sum += prob;
        listOfNames.add("а) не содержит одинаковых цифр     средн. вер. = " + sum / numberOfExperiments);
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт б)
        System.out.println("Б)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfSituations);
            for (int i = 0; i < numberOfSituations; i++) {
                if (    (numbers[i][0] == numbers[i][1] && numbers[i][0] != numbers[i][2] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][2] && numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][1] && numbers[i][0] != numbers[i][2]) ||
                        (numbers[i][1] == numbers[i][2] && numbers[i][1] != numbers[i][0] && numbers[i][1] != numbers[i][3]) ||
                        (numbers[i][1] == numbers[i][3] && numbers[i][1] != numbers[i][0] && numbers[i][1] != numbers[i][2]) ||
                        (numbers[i][2] == numbers[i][3] && numbers[i][2] != numbers[i][0] && numbers[i][2] != numbers[i][1])    )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / numberOfSituations;

            System.out.println("       probability = " + (double) amountOfValidNumbers/ numberOfSituations);
        }
        System.out.println();
        listOfArrays.add(probability.clone());
        for (double prob : probability) sum += prob;
        listOfNames.add("б) имеет две одинаковые цифры     средн.вер. = " + sum / numberOfExperiments);
        System.out.println("Average probability of 2 same digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт в)
        System.out.println("В)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfSituations);
            for (int i = 0; i < numberOfSituations; i++) {
                if (    (numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][2] && numbers[i][0] != numbers[i][3]) ||
                        (numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][2]) ||
                        (numbers[i][0] == numbers[i][2] && numbers[i][0] == numbers[i][3] && numbers[i][0] != numbers[i][1]) ||
                        (numbers[i][1] == numbers[i][2] && numbers[i][1] == numbers[i][3] && numbers[i][1] != numbers[i][0])    )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / numberOfSituations;

            System.out.println("       probability = " + (double) amountOfValidNumbers/ numberOfSituations);
        }
        System.out.println();
        listOfArrays.add(probability.clone());
        for (double prob : probability) sum += prob;
        listOfNames.add("в) имеет три одинаковые цифры     средн.вер. = " + sum / numberOfExperiments);
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();

        //пункт г)
        System.out.println("Г)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfSituations);
            for (int i = 0; i < numberOfSituations; i++) {
                if (    numbers[i][0] == numbers[i][1] && numbers[i][2] == numbers[i][3] && numbers[i][0] != numbers[i][2] ||
                        numbers[i][0] == numbers[i][2] && numbers[i][1] == numbers[i][3] && numbers[i][0] != numbers[i][1] ||
                        numbers[i][0] == numbers[i][3] && numbers[i][1] == numbers[i][2] && numbers[i][0] != numbers[i][1]  )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / numberOfSituations;

            System.out.println("       probability = " + (double) amountOfValidNumbers/ numberOfSituations);
        }
        System.out.println();
        listOfArrays.add(probability.clone());
        for (double prob : probability) sum += prob;
        listOfNames.add("г) содержит две пары одинаковых цифр     средн.вер. = "+ sum / numberOfExperiments);
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();


        //пункт д)
        System.out.println("Д)");
        sum = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            amountOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfSituations);
            for (int i = 0; i < numberOfSituations; i++) {
                if (    numbers[i][0] == numbers[i][1] && numbers[i][0] == numbers[i][2] && numbers[i][0] == numbers[i][3] &&
                        numbers[i][1] == numbers[i][2] &&
                        numbers[i][2] == numbers[i][3] )
                    amountOfValidNumbers++;
            }
            probability[experiment] = (double) amountOfValidNumbers / numberOfSituations;

            System.out.println("       probability = " + (double) amountOfValidNumbers/ numberOfSituations);
        }
        System.out.println();
        listOfArrays.add(probability.clone());
        for (double prob : probability) sum += prob;
        listOfNames.add("д) состоит из одинаковых цифр     средн.вер. = " + sum / numberOfExperiments);
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);

        createChart();
    }

    private static void createChart() {
        XYLineChart_AWT chartA = new XYLineChart_AWT("2.10",
                "", listOfArrays, listOfNames, "Номер эксперимента", "Вероятность");
        chartA.createAllInOneDataSet(listOfArrays, listOfNames);
        chartA.pack();
        RefineryUtilities.centerFrameOnScreen(chartA);
        chartA.setVisible(true);
    }
}
