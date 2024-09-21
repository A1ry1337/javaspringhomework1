package base.mod1;

public class Mod1 {
    /**
     * Задача 1:
     * Найти сумму всех чисел от 0 до 1000, которые делятся на 3 или 5.
     * Если число кратно 3 или 5, оно добавляется к итоговой сумме.
     * Функция возвращает эту сумму.
     */
    public static int sum_x3_x5() {
        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }
        return sum;
    }

    /**
     * Задача 2:
     * Найти минимальный элемент в двумерном массиве целых чисел.
     * Функция принимает двумерный массив и возвращает наименьшее значение в этом массиве.
     */
    public static int matrix_min_el(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) min = matrix[i][j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum_x3_x5());  // 1 задача

        int[][] matrix = {  // 2 задача
                {20, 34, 2},
                {9, 12, 18},
                {3, 4, 5}
        };
        System.out.println(matrix_min_el(matrix));
    }
}