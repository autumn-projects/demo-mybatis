package prototype.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(sqlSession));
    }

    /**
     * 1.xml解析
     * 2.
     */
    static class TestMapperXml {
        public static final String namespace = "prototype.v1.TestMapper";

        public static final Map<String, String> methodSqlMapping = new HashMap<String, String>();

        static {
            methodSqlMapping.put("selectByPrimaryKey", "select * from test where id = %d");
        }
    }

}
