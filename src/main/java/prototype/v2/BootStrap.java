package prototype.v2;


import prototype.v1.Test;
import prototype.v2.config.Configuration;
import prototype.v2.config.mappers.TestMapper;
import prototype.v2.executor.ExecutorFactory;
import prototype.v2.session.SqlSession;

import java.io.IOException;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setScanPath("prototype.v2.config.mappers");
        configuration.build();
        SqlSession sqlSession = new SqlSession(configuration,
                ExecutorFactory.get(ExecutorFactory.ExecutorType.SIMPLE.name(), configuration));
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        long start = System.currentTimeMillis();
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
}
