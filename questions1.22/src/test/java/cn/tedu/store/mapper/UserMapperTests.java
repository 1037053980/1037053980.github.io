package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

//@SpringBootTest注解写在类上，用来说明该类是一个测试类
//在测试方法执行前，会自动加载相应的测试环境
@SpringBootTest
public class UserMapperTests {

    //@Autowired注解，该注解自动从框架中取出满足要求的对象，
    //赋值给该注解标注的属性
    @Autowired
    private UserMapper userMapper;
    //@Test注解，写在方法上，说明该方法是一个测试，可单独运行
    //@Test注解，写在方法上，说明该方法是一个测试，可单独运行。
    @Test
    void insert(){
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setUsername("jackson4");
        user.setPassword("123456");
        user.setPhone("13800138001");
        user.setEmail("jackson@qq.com");
        user.setGender(1);
        user.setType(0);
        user.setGmtCreate(now);
        user.setGmtModified(now);
        Integer rows = userMapper.insert(user);
        System.out.println("受影响的行数：" + rows);
    }

    @Test
    void test2(){
        String username = "jackson";
        User user = userMapper.findByUsername(username);
        System.out.println(user);
    }

    @Test
    void test3(){
        Integer id = 16;
        String password = "888888";
        LocalDateTime now = LocalDateTime.now();
        Integer rows = userMapper.updatePassword(id, password, now);
        System.out.println("受影响的行数："+rows);
    }

    @Test
    void findById(){
        Integer id = 1;
        User user = userMapper.findById(id);
        System.out.println(user);
    }

    @Test
    void updateInfoById(){
        User user = new User();
        user.setId(21);
        user.setPhone("1388888888");
        user.setEmail("1388888888@sina.com");
        user.setGender(1);
        user.setGmtModified(LocalDateTime.now());
        Integer rows = userMapper.updateInfoById(user);
        System.out.println("受影响的行数：" + rows);
    }



}
