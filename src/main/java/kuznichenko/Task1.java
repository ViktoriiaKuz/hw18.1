package kuznichenko;

import java.util.Arrays;

/**
 * С помощью многопоточности заполнить массива строк из 100 млн элементов.
 * Если индекс делится на 3 без остатка - записать в ячейку "Fizz",
 * если делится на 5 без остатка - "Buzz". Во всех остальных случаях записать
 * в ячейку строковое представление ее индекса. Сравнить время выполнения программы с одним потоком и с несколькими.
 * Количество потоков на ваше усмотрение.
 */

public class Task1 {


    public static void main(String[] args) throws InterruptedException {

        String[] array = new String[100_000_000];

        SetArray setArray1 = new SetArray(array, 0, 33_333_333);
        SetArray setArray2 = new SetArray(array, 33_333_333, 66_666_666);
        SetArray setArray3 = new SetArray(array, 66_666_666, 99_999_999);

        SetArray[] setArrays = new SetArray[]{setArray1, setArray2, setArray3};

        int i = 0;
        for (SetArray setArray : setArrays) {
            i++;

            Thread thread = new Thread(setArray, String.valueOf(i));

            thread.start();
            thread.join();

        }


    }

}
