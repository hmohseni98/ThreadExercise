package Q4;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

class CalcSizeDirectoryMu {
    private static final LinkedBlockingQueue<Long> queue = new LinkedBlockingQueue<>();

    private static final ThreadWithQueue t1 = new ThreadWithQueue(queue);
    private static final ThreadWithQueue t2 = new ThreadWithQueue(queue);
    private static final ThreadWithQueue t3 = new ThreadWithQueue(queue);
    private static final ThreadWithQueue t4 = new ThreadWithQueue(queue);

    private static long getFolderSize(File folder) {

        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isHidden())
                continue;
            if (files[i].isFile()) {
                queue.offer(files[i].length());
            } else {
                queue.offer(getFolderSize(files[i]));
            }
        }
        return length;
    }

    public static void main(String[] args) throws InterruptedException {
        File file1 = new File("E:\\");
        Long before = System.currentTimeMillis();
        getFolderSize(file1);
        Thread.sleep(30);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        while (true) {
            if (queue.isEmpty()) {
                t1.setFinished(true);
                t2.setFinished(true);
                t3.setFinished(true);
                t4.setFinished(true);
                break;
            }
        }
        Long size = t1.getCalcSize() + t2.getCalcSize() + t3.getCalcSize() + t4.getCalcSize();
        Long after = System.currentTimeMillis();
        System.out.println("Time to run:" + (after - before));
        System.out.println("Size of " + file1 + " is "
                + size + " B");
        System.out.println("Size of " + file1 + " is "
                + (double) size / 1024 + " KB");
        System.out.println("Size of " + file1 + " is "
                + (double) size / (1024 * 1024)
                + " MB");
        System.out.println("Size of " + file1 + " is "
                + (double) size / (1024 * 1024 * 1024)
                + " GB");
    }
}
