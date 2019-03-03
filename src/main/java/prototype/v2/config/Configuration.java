package prototype.v2.config;

import java.io.IOException;

public class Configuration {

    private String scanPath;

    private MapperRegistory mapperRegistory = new MapperRegistory();

    public Configuration scanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    public void build() throws IOException {
        if (null == scanPath || scanPath.length() < 1) {
            throw new RuntimeException("scan path is required .");
        }
    }

    public static void main(String[] args) throws IOException {
        new Configuration().scanPath("prototype/v2/config/mappers").build();
    }

    public MapperRegistory getMapperRegistory() {
        return mapperRegistory;
    }

    public void setMapperRegistory(MapperRegistory mapperRegistory) {
        this.mapperRegistory = mapperRegistory;
    }


    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }
}
