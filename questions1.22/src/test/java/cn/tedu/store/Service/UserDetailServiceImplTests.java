package cn.tedu.store.Service;

import cn.tedu.store.entity.UserDetail;
import cn.tedu.store.service.IUserDetailService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UserDetailNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserDetailServiceImplTests {

    @Autowired
    private IUserDetailService userDetailService;

    @Test
    void addToUserDetail(){
        LocalDateTime now = LocalDateTime.now();
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(2);
        userDetail.setAcTotal(22);
        userDetail.setWoTotal(33);
        userDetail.setSolvedTotal(55);
        userDetail.setGmtModified(now);
        userDetail.setGmtCreate(now);
        try{
            userDetailService.addToUserDetail(userDetail);
        }catch (InsertException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void updateUserDetailByUid(){
        LocalDateTime now = LocalDateTime.now();
        UserDetail userDetail = new UserDetail();
        userDetail.setWoTotal(1);
        userDetail.setAcTotal(2);
        userDetail.setSolvedTotal(3);
        userDetail.setUid(2);
        userDetail.setGmtModified(now);
        userDetailService.updateUserDetailByUid(userDetail);
    }

    @Test
    void getUserDetailByUid(){
        Integer uid = 2;
        try{
            UserDetail userDetail = userDetailService.getUserDetailByUid(uid);
            System.out.println(userDetail);
        }catch (UserDetailNotFoundException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
