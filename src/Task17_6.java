public class Task17_6 {

    private static int n = 7;
    private static double[][] matrix = new double[n][n*2];

    public static void solve() {
        calculate();
    }

    public static void calculate() {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matrix[i][j] = i + 1;
                matrix[j][i] = i + 1;
            }
            matrix[i][i+n] = 1;
        }

        System.out.println("Дана матрица:");
        for (int i = 0; i < n; i++) {
            System.out.print("(\t");
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println(")");
        }

        System.out.println();
        System.out.println("Найдём обратную матрицу.");
        System.out.println();
        System.out.println("Для вычисления обратной матрицы запишем матрицу, дописав к ней справа единичную матрицу:");
        printMatrix(matrix);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    matrix[j][k] -= matrix[i][k];
                }

            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] -= matrix[i+1][j];
            }
        }

        System.out.println();
        System.out.println("Используя элементарные преобразования над строками матрицы, преобразуем левую часть полученной матрицы в единичную.");
        printMatrix(matrix);

        System.out.println();
        System.out.println();
        System.out.println("Матрица, обратная данной");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("(\t");
            for (int j = n; j < matrix[0].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println(")");
        }
    }

    private static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("(\t");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println(")");
        }
    }

}
