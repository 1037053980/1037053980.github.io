package cn.tedu.store.demo2;

public class MyBatisUserDaoImpl implements UserDao{

    @Override
    public void insert() {
        System.out.println("MyBatis插入成功");
    }

    @Override
    public void deleteAll() {
        System.out.println("MyBatis删除成功");
    }
}
