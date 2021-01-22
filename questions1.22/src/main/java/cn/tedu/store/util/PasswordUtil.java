package cn.tedu.store.util;

import org.springframework.util.DigestUtils;

public class PasswordUtil {
    private static final String SALT="明天去哪儿";//盐值
    /**
     * 对明文密码按MD5算法加密
     * @param password 明文密码
     * @return 加密后的密码
     */
    public static String getMd5Password(String password){

        for(int i=0; i<3; i++){
            password = DigestUtils.md5DigestAsHex((SALT + password + SALT).getBytes())
                    .toUpperCase();
        }
        return password;
    }
}
