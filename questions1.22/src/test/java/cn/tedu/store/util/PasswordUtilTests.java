package cn.tedu.store.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordUtilTests {

    @Test
    void test(){
        String password = "123456";
        String md5Password = PasswordUtil.getMd5Password(password);
        System.out.println(md5Password);
    }

}
