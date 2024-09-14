
public class Main {
    /**
     * Задача:
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

    public static void main(String[] args) {
        System.out.println(sum_x3_x5());
    }
}