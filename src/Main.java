import java.util.Random;

public class Main {

    public static void main(String[] args) {
        task2_10();
    }

    public static int getRandomIntegerBetweenRange(int min, int max){
        int numb = (int) (Math.random()*((max-min)+1))+min;
        return numb;
    }

    static int[][] createArrayOfNumbers(int numberOfExperiments) {
        int[][] numbers = new int[numberOfExperiments][4];
        for (int i = 0; i < numberOfExperiments; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = getRandomIntegerBetweenRange(0, 9);
            }
        }
        return numbers;
    }

    public static void task2_10() {
        int size = 10;
        int numberOfExperiments = 10;
        int numberOfValidNumbers;
        int[][] numbers;
        double[] probability = new double[numberOfExperiments];

        System.out.println("________________________2.10__________________________");
        //пункт a)
        System.out.println("A)");
        numberOfValidNumbers = 0;

        System.out.println();
        //пункт б)
        System.out.println("Б)");
        numberOfValidNumbers = 0;
        for (int experiment = 0; experiment < numberOfExperiments; experiment++) {
            numberOfValidNumbers = 0;
            numbers = createArrayOfNumbers(numberOfExperiments);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(numbers[i][j]);
                }
                System.out.print(" ");
                if (numbers[i][0] == numbers[i][1] || numbers[i][0] == numbers[i][2] || numbers[i][0] == numbers[i][3] ||
                        numbers[i][1] == numbers[i][2] || numbers[i][1] == numbers[i][3] ||
                        numbers[i][2] == numbers[i][3]) numberOfValidNumbers += 1;
            }
            probability[experiment] = (double) numberOfValidNumbers / size;

            System.out.println("       probability = " + (double) numberOfValidNumbers/size);
        }
        System.out.println();
        double sum = 0.0;
        for (int i = 0; i < probability.length; i++) {
            sum += probability[i];
        }
        System.out.println("Average probability of 2 same digits in number = " + sum / numberOfExperiments);
        System.out.println();


        //пункт в)
        System.out.println("В)");
        numberOfValidNumbers = 0;
        System.out.println();

        //пункт г)
        System.out.println("Г)");
        numberOfValidNumbers = 0;
        System.out.println();

        //пункт д)
        System.out.println("Д)");
        numberOfValidNumbers = 0;
        System.out.println();

        System.out.println("______________________________________________________");
    }

}
