package cn.tedu.store.demo2;

public class JdbcUserDaoImpl implements UserDao  {
    @Override
    public void insert() {
        System.out.println("插入成功");
    }

    @Override
    public void deleteAll() {
        System.out.println("删除成功");
    }
}
