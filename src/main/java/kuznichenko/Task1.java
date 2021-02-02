package kuznichenko;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * С помощью многопоточности заполнить массива строк из 100 млн элементов.
 * Если индекс делится на 3 без остатка - записать в ячейку "Fizz",
 * если делится на 5 без остатка - "Buzz". Во всех остальных случаях записать
 * в ячейку строковое представление ее индекса. Сравнить время выполнения программы с одним потоком и с несколькими.
 * Количество потоков на ваше усмотрение.
 */

public class Task1 {


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        String[] array = new String[100_000_000];
        int i = 0;
        int y = array.length/5;
//        SetArray setArray0 = new SetArray(array, 0 , 19_999_999);
//        SetArray setArray1 = new SetArray(array, 20_000_000 , 39_999_999);
//        SetArray setArray2 = new SetArray(array, 40_000_000 , 59_999_999);
//        SetArray setArray3 = new SetArray(array, 60_000_000 , 79_999_999);
//        SetArray setArray4 = new SetArray(array, 80_000_000 , 99_999_999);
        List<SetArray> setArrays = new ArrayList<>();
        for (SetArray setArray: setArrays) {
            setArrays.add(new SetArray(array, i, y));
            i = y;
            y = y + y;
        }
        for (SetArray setArray: setArrays) {
            int z = 0;
            z++;

            Thread thread = new Thread( setArray, String.valueOf(i));

            thread.start();

            threadList.add(thread);

        }
        for(Thread thread : threadList){
            thread.join();
        }

        long finish = System.currentTimeMillis();
        System.out.println(finish-start);

    }

}
