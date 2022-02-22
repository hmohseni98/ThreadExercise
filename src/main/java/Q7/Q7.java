package Q7;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q7 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        Connection connection;
//        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Long before = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String sql = "INSERT INTO test (f_name, l_name) VALUES (?,?)";
                    try {
                        PreparedStatement preparedStatement = DBCPDataSource.getConnection().prepareStatement(sql);
                        for (int i = 0; i < 1000000; i++) {
                            preparedStatement.setString(1, "hassan" + i);
                            preparedStatement.setString(2, "mohseni" + i);
                            preparedStatement.addBatch();
                        }
                        preparedStatement.executeBatch();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        Long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
