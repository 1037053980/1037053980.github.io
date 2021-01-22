package cn.tedu.store.Service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.server.ServerCloneException;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    void register() {
        User user = new User();
        user.setUsername("david");
        user.setPassword("666666");
        try {
            userService.register(user);
            System.out.println("注册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void login(){
        String username = "jackson4";
        String password = "123456";
        try{
            User user = userService.login(username, password);
            System.out.println(user);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void changePassword(){
        try {
            userService.changePassword(18,"666666","123456");
            System.out.println("修改密码成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getById(){
        Integer id = 1;
        try{
            User user = userService.getById(id);
             System.out.println(user);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void changeInfoById() {
        Integer id = 19;
        User user = new User();
        user.setPhone("13999999999");
        user.setEmail("root9@qq.com");
        user.setGender(1);
        try {
            userService.changeInfoById(id, user);
            System.out.println("修改个人信息成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isAdminister(){
        Integer id = 1;
        Integer result = userService.isAdminister(id);
        System.out.println(result);
    }
}
