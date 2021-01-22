package cn.tedu.store.mapper;

import cn.tedu.store.entity.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserDetailMapperTests {

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Test
    void insert(){
        LocalDateTime now = LocalDateTime.now();
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(1);
        userDetail.setAcTotal(10);
        userDetail.setWoTotal(20);
        userDetail.setSolvedTotal(30);
        userDetail.setGmtCreate(now);
        userDetail.setGmtModified(now);
        Integer result = userDetailMapper.insert(userDetail);
        System.out.println(result);
    }

    @Test
    void updateInfoByUid(){
        LocalDateTime now = LocalDateTime.now();
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(2);
        userDetail.setAcTotal(1);
        userDetail.setWoTotal(2);
        userDetail.setSolvedTotal(3);
        userDetail.setGmtModified(now);
        userDetailMapper.updateInfoByUid(userDetail);
    }

    @Test
    void findByUid(){
        Integer uid = 1;
        UserDetail byUid = userDetailMapper.findByUid(uid);
        System.out.println(byUid);
    }
}
