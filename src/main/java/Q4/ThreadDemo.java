package Q4;

import java.io.File;

public class ThreadDemo extends Thread {
    private Long calcSize;
    private File file;

    public ThreadDemo() {
        this.calcSize = 0L;
    }

    @Override
    public synchronized void run() {
        while (true) {
            if (file != null) {
                calcSize += file.length();
            }
        }
    }

    public Long getCalcSize() {
        return calcSize;
    }


    public void setFile(File file) {
        this.file = file;
    }
}
