package com.example.demo.service.thrift;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.thrift.TException;

/**
 * @author nut on 2018/12/19.
 */
@Service
public class UserServiceImpl implements UserService.Iface{

    @Override
    public User getUserById(int id) throws TException {
        return new User(1, "test", 1);
    }
}
