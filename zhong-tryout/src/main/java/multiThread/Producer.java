package multiThread;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private static volatile Integer pId = 0;
    private static volatile AtomicInteger id = new AtomicInteger(0);
    private PriorityBlockingQueue<Integer> bpq;
    private Integer producerId;

    public Producer(PriorityBlockingQueue<Integer> bpq) {
        this.bpq = bpq;
        pId++;
        this.producerId = pId;
    }

    @Override
    public void run() {
        while(id.get() < 5000) {
            int num = id.incrementAndGet();
            System.out.format("Procuder(%d) Producing Product %d \n", this.producerId, num);
            bpq.put(num);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
