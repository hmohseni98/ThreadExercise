package Q6;

class StarvationDemo extends Thread {

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " Thread execution starts");
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        StarvationDemo thread1 = new StarvationDemo();
        StarvationDemo thread2 = new StarvationDemo();
        StarvationDemo thread3 = new StarvationDemo();
        StarvationDemo thread4 = new StarvationDemo();
        StarvationDemo thread5 = new StarvationDemo();

        thread1.setPriority(5);
        thread2.setPriority(4);
        thread3.setPriority(3);
        thread4.setPriority(2);
        thread5.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
