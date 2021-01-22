package cn.tedu.store.service.impl;

import cn.tedu.store.entity.UserDetail;
import cn.tedu.store.mapper.UserDetailMapper;
import cn.tedu.store.service.IUserDetailService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UserDetailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements IUserDetailService {

    @Autowired
    private UserDetailMapper userDetailMapper;


    @Override
    public void addToUserDetail(UserDetail userDetail) {
        Integer result = userDetailMapper.insert(userDetail);
        if( result != 1){
            throw new InsertException("系统繁忙请稍后再试");
        }
    }

    @Override
    public void updateUserDetailByUid(UserDetail userDetail) {
        Integer result = userDetailMapper.updateInfoByUid(userDetail);
        if( result != 1){
            throw new InsertException("系统繁忙请稍后再试");
        }
    }

    @Override
    public UserDetail getUserDetailByUid(Integer uid) {
        UserDetail userDetail = userDetailMapper.findByUid(uid);
        if( userDetail == null ){
            throw new UserDetailNotFoundException("未找到该用户信息");
        }
        return userDetail;
    }
}
