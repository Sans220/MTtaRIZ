public class Lab2 {
// 1. Метод, який виводить n рядків з "*"
    public static void printStars(int n) {
        for (int i = 1; i <= n; i++) {
            // В кожному рядку кількість "*" дорівнює номеру рядка
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // 2. Метод, який створює і виводить 2D масив, де кожен елемент більший за попередній на 5
    public static void createAndPrintArray(int rows, int cols) {
        int[][] arr = new int[rows][cols];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = value;
                value += 3;
            }
        }

        // Вивід масиву
        System.out.println("\nДвовимірний масив:");
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    // Головний метод для тестування
    public static void main(String[] args) {

        // ТЕСТ 1: Вивід ялинки
        System.out.println("Ялинка з *:");
        printStars(6);

        // ТЕСТ 2: 2D масив
        createAndPrintArray(3, 4);
    }
}
