package multiThread;

import java.util.concurrent.PriorityBlockingQueue;

public class Consumer implements Runnable {
    private static Integer cId = 0;
    private PriorityBlockingQueue<Integer> bpq;
    private Integer comsumerId;

    public Consumer(PriorityBlockingQueue<Integer> bpq) {
        this.bpq = bpq;
        cId++;
        comsumerId = cId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer productId = bpq.take();
                System.out.format("Consumer(%d) comsuming product %d\n", comsumerId, productId);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
