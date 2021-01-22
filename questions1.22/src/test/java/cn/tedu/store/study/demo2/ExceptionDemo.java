package cn.tedu.store.study.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceptionDemo {

    @Test
    void Test1(){
        int a=6, b=0, c;
        try{
            c = a/b ;
            System.out.println("c=" + c);
        }catch (Exception e){
            System.out.println("除数不能为0");
        }
        System.out.println("程序结束");
    }
}
