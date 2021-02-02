package kuznichenko;

import java.util.Arrays;

public class SetArray implements Runnable  {


    private final String[] array;
    private final int from;
    private final int to;

    public SetArray(String[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {

        for (int i = from; i < to; i++) {
                if (i % 3 == 0) {
                    array[i] = "Fizz";
                } else if (i % 5 == 0) {
                    array[i] = "Buzz";
                } else {
                    array[i] = String.valueOf(i);
                }
                System.out.println(array[i] + Thread.currentThread());
            }
        //System.out.println(Arrays.toString(array));

        }

}

