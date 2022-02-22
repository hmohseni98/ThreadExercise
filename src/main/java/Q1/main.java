package Q1;

public class main {
    public static void main(String[] args) throws InterruptedException {
        BackgroundThread t1 = new BackgroundThread();
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(2000);
        Thread.interrupted();
    }
}
