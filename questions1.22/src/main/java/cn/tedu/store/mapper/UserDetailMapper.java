package cn.tedu.store.mapper;

import cn.tedu.store.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailMapper {

    Integer insert(UserDetail userDetail);

    Integer updateInfoByUid(UserDetail userDetail);

    UserDetail findByUid(Integer uid);

}
