package com.example.demo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.ReferenceBean;

import com.example.demo.service.dubbo.WrapperService;
import com.example.demo.service.thrift.User;
import com.example.demo.service.thrift.UserService;
import javax.annotation.Resource;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nut on 2018/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoTest {

    @Reference
    private WrapperService wrapperService;


    @Resource
    private ApplicationConfig applicationConfig;

    @Resource
    private RegistryConfig registryConfig;

    @Test
    public void callThrift() throws TException {
        ReferenceBean<UserService.Iface> referenceBean = new ReferenceBean<>();
        referenceBean.setApplication(applicationConfig);
        referenceBean.setProtocol("thrift");
        referenceBean.setRegistry(registryConfig);
        referenceBean.setInterface(UserService.Iface.class);
        referenceBean.setCheck(true);
        User u = referenceBean.get().getUserById(1);
        System.out.println(u);
    }


    @Test
    public void callDubbo() {
        int i = wrapperService.pure();
        System.out.println(i);
    }

    @Test
    public void callDubboWithThrift() throws TException {
        int i = wrapperService.wrap();
        System.out.println(i);
    }

}
