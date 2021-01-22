package cn.tedu.store.demo2;

public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new JdbcUserDaoImpl();
        userDao.insert();
        userDao.deleteAll();

        userDao = new MyBatisUserDaoImpl();
        userDao.insert();
        userDao.deleteAll();
    }
}
