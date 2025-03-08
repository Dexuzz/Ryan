import java.util.Scanner;

public class MatrixOperations {

    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] sumMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length, cols1 = matrix1[0].length;
        int rows2 = matrix2.length, cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Matrix multiplication not possible!");
        }

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static boolean isSymmetric(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        if (rows != cols) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns: ");
        int rows = scanner.nextInt(), cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        System.out.println("Enter elements for first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Sum of all elements in the first matrix: " + sumMatrix(matrix1));

        System.out.println("Matrix Addition:");
        printMatrix(addMatrices(matrix1, matrix2));

        System.out.println("Matrix Multiplication:");
        try {
            printMatrix(multiplyMatrices(matrix1, matrix2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Is the first matrix symmetric? " + (isSymmetric(matrix1) ? "Yes" : "No"));

        System.out.println("Transpose of the first matrix:");
        printMatrix(transposeMatrix(matrix1));

        scanner.close();
    }
}
