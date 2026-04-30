package com.bell.demo.task1;

import java.util.Scanner;

//для проверки лучше делать не запуская Spring приложение из папки task2. Проверять отдельно
public class TwoDimensionalArraySolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = getValidInput(scanner, "Введите число n (количество строк): ");
        int m = getValidInput(scanner, "Введите число m (количество столбцов): ");

        int[][] initialArray = new int[n][m];
        fillArrayWithRandomValues(initialArray);

        int[][] sumResult = sumValuesInArray(initialArray);

        System.out.println("\nИзначальный сгенерированный массив:");
        printPrettyArray(initialArray);

        System.out.println("\nМассив сумм соседних элементов:");
        printPrettyArray(sumResult);

        scanner.close();
    }

    private static int getValidInput(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: размерность должна быть больше нуля. Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: необходимо ввести целое число. Попробуйте еще раз.");
            }
        }
        return value;
    }

    private static void fillArrayWithRandomValues(int[][] arrayToFill) {
        for (int i = 0; i < arrayToFill.length; i++) {
            for (int j = 0; j < arrayToFill[i].length; j++) {
                arrayToFill[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
    }

    private static int[][] sumValuesInArray(int[][] baseArray) {
        int n = baseArray.length;
        int m = baseArray[0].length;
        int[][] resultArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0) {
                    resultArray[i][j] += baseArray[i - 1][j];
                }
                if (i != n - 1) {
                    resultArray[i][j] += baseArray[i + 1][j];
                }
                if (j != 0) {
                    resultArray[i][j] += baseArray[i][j - 1];
                }
                if (j != m - 1) {
                    resultArray[i][j] += baseArray[i][j + 1];
                }
            }
        }

        return resultArray;
    }

    private static void printPrettyArray(int[][] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            for (int j = 0; j < arrayToPrint[i].length; j++) {
                System.out.printf("%3d ", arrayToPrint[i][j]);
            }
            System.out.println();
        }
    }
}