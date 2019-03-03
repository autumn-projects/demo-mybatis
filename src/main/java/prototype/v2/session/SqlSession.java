package prototype.v2.session;

import prototype.v2.config.Configuration;
import prototype.v2.config.MapperRegistory;
import prototype.v2.executor.Executor;
import prototype.v2.mapper.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * Created by James on 2017-07-01.
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public Configuration getConfiguration() {
        return configuration;
    }

    //关联起来
    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this, clazz));
    }

    public <T> T selectOne(MapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        return executor.query(mapperData, parameter);
    }
}
