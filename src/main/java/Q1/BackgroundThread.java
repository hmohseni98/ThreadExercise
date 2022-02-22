package Q1;

public class BackgroundThread extends Thread{
    @Override
    public void run() {
        int counter = 0;
        while (true) {
            counter++;
            System.out.println(counter + ". hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
