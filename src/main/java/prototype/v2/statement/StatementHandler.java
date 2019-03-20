package prototype.v2.statement;


import prototype.v2.config.Configuration;
import prototype.v2.config.MapperRegistory;
import prototype.v2.result.ResultSetHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementHandler {
    private final Configuration configuration;

    private final ResultSetHandler resultSetHandler;

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new ResultSetHandler(configuration);
    }

    public <E> E query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        try {
            //JDBC
            Connection conn = getConnection();
            //TODO ParameterHandler
            PreparedStatement pstmt = conn.prepareStatement(String.format(mapperData.getSql(),
                    Integer.parseInt(String.valueOf(parameter))));
            pstmt.execute();
            //ResultSetHandler
            return (E) resultSetHandler.handle(pstmt.getResultSet(), mapperData.getType());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String username = "test";
        String password = "123456";
        String url = "jdbc:mysql://115.28.94.53:3306/test?autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
