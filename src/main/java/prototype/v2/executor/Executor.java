package prototype.v2.executor;

import prototype.v2.config.MapperRegistory;

public interface Executor {

    <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception;

}
