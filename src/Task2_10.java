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
        int size = 10;
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
        for (double prob : probability) sum += prob;
        System.out.println("Average probability of all different digits in number = " + sum / numberOfExperiments);
        System.out.println();


        System.out.println("______________________________________________________");
    }
}
