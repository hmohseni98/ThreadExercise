package Q3;

public class CheckingAccount {
    private int balance;
    private boolean turn;

    public CheckingAccount(int balance) {
        this.balance = balance;
        turn = false;
    }

    public synchronized boolean withdraw(int amount) {
        if (amount <= balance) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
            balance -= amount;
            return true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ie){
        }
        return false;
    }

    public static void main(String[] args) {
        final CheckingAccount ca = new CheckingAccount(100);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 10; i++) {
                    System.out.println(name + "withdraws $10: " +
                            ca.withdraw(10));
                }
            }
        };
        Thread thdHusband = new Thread(r);
        thdHusband.setName("Husband");
        Thread thdWife = new Thread(r);
        thdWife.setName("Wife");
        thdHusband.start();
        thdWife.start();
    }
}
