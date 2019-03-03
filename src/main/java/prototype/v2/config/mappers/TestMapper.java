package prototype.v2.config.mappers;


import prototype.v1.Test;

public interface TestMapper { //prototype.v2.config.mappers.TestMapper

    Test selectByPrimaryKey(Integer userId);

}