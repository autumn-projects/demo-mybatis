package building;


public class Entry {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new SimpleExecutor());
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        Test test = mapper.selectByPrimaryKey(1);
        System.out.println(test);
    }
}
