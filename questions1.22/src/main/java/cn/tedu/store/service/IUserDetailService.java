package cn.tedu.store.service;

import cn.tedu.store.entity.UserDetail;

public interface IUserDetailService {

    void addToUserDetail(UserDetail userDetail);

    void updateUserDetailByUid(UserDetail userDetail);

    UserDetail getUserDetailByUid(Integer uid);
}
