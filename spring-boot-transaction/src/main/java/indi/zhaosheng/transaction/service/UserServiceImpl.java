package indi.zhaosheng.transaction.service;

import indi.zhaosheng.transaction.dao.UserMapper;
import indi.zhaosheng.transaction.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muluo
 * @description
 * @date 2020/5/19 21:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserPo> list() {
        return userMapper.selectList(null);
    }
}
