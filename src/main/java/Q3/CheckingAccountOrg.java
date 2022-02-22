package Q3;

public class CheckingAccountOrg {
    private int balance;

    public CheckingAccountOrg(int balance) {
        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount) throws InterruptedException {
        if (amount <= balance) {
            Thread.sleep(1);
            balance -= amount;
            return true;
        }
        Thread.sleep(1);
        return false;
    }

    public static void main(String[] args) {
        final CheckingAccountOrg ca = new CheckingAccountOrg(100);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println(name + "withdraws $10: " +
                                ca.withdraw(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thHusband = new Thread(r);
        thHusband.setName("Husband");
        Thread thWife = new Thread(r);
        thWife.setName("Wife");
        thHusband.start();
        thWife.start();
    }
}
