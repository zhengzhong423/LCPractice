package multiThread;

import java.util.concurrent.PriorityBlockingQueue;

public class BlockingPQ {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> bpq = new PriorityBlockingQueue<>();
        for (int i = 0; i <  20; i++) {
            new Thread(new Producer(bpq)).start();
        }
        for (int j = 0; j < 100; j++) {
            new Thread(new Consumer(bpq)).start();
        }
    }
}
