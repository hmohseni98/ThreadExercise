package Q4;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadWithQueue extends Thread {

    private LinkedBlockingQueue<Long> queue;
    private Boolean isFinished = false;
    private Long calcSize = 0L;

    public ThreadWithQueue(LinkedBlockingQueue<Long> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        Long value = null;
        while (!isFinished) {
            value = queue.poll();
            if (value != null)
                calcSize += value;
        }
    }


    public void setFinished(Boolean finished) {
        isFinished = finished;
    }


    public Long getCalcSize() {
        return calcSize;
    }
}
