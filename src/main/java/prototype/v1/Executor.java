package prototype.v1;

public interface Executor {

    <T> T query(String statement, String parameter);

}
