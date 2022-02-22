package Q4;

import java.io.File;

class CalcSizeDirectorySq {
    private static long getFolderSize(File folder) {

        long length = 0;
        // listFiles() is used to list the
        // contents of the given folder
        File[] files = folder.listFiles();

        int count = files.length;


        // loop for traversing the directory
        for (int i = 0; i < count; i++) {
            if (files[i].isHidden())
                continue;
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating an instances of file class
        File file1 = new File("E:\\");
        Long before = System.currentTimeMillis();
        long size = getFolderSize(file1);
        Long after = System.currentTimeMillis();
        System.out.println("Time to run:" + (after - before));
        // Size of folder in Bytes
        System.out.println("Size of " + file1 + " is "
                + size + " B");
        // Size of folder in Kilobytes
        System.out.println("Size of " + file1 + " is "
                + (double) size / 1024 + " KB");
        // Size of folder in Megabytes
        System.out.println("Size of " + file1 + " is "
                + (double) size / (1024 * 1024)
                + " MB");
        System.out.println("Size of " + file1 + " is "
                + (double) size / (1024 * 1024 * 1024)
                + " GB");
    }
}
