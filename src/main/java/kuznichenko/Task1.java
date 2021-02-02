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
        int y = (array.length/5)-1;

        List<SetArray> setArrays = new ArrayList<>();

        for (int a = 0; a < 3; a++) {
            setArrays.add(new SetArray(array, i, y));
            i = y+1;
            y = (y*2)+1;
        }
        int z = 0;
        for (SetArray setArray: setArrays) {

            z++;

            Thread thread = new Thread( setArray, String.valueOf(z));

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
