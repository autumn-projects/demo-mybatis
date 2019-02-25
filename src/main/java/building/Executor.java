package building;

public interface Executor {

    <T> T query(String statement, String parameter);

}
