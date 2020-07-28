package execute;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by linhnm20 on Jul, 2020
 */

@Data
public class CallableWorker implements Callable<Integer> {

    private int num;
    private Random random;

    public CallableWorker(int num) {
        this.num = num;
        this.random = new Random();
    }

    public Integer call() throws Exception {
        Thread.sleep(random.nextInt(10) * 1000);
        int result = num * num;
        System.out.println("Complete " + num);
        return result;
    }
}
