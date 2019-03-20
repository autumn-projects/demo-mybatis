package prototype.v1;

import java.sql.*;

public class SimpleExecutor implements Executor {

    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "test";
            String password = "123456";
            String url = "jdbc:mysql://115.28.94.53:3306/test?autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
            connection = DriverManager.getConnection(url, username, password);

            preparedStatement = connection.prepareStatement(
                    String.format(statement, Integer.parseInt(parameter)));
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) test;
    }

}
