package prototype.v2.executor;


import prototype.v2.config.Configuration;
import prototype.v2.config.MapperRegistory;
import prototype.v2.statement.StatementHandler;

public class SimpleExecutor implements Executor {
    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public <E> E query(MapperRegistory.MapperData mapperData, Object parameter)
            throws Exception {
        //初始化StatementHandler --> ParameterHandler --> ResultSetHandler
        StatementHandler handler = new StatementHandler(configuration);
        return (E) handler.query(mapperData, parameter);
    }
}