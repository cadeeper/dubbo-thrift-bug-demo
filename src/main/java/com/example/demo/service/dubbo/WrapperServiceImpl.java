package com.example.demo.service.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.RpcContext;
import com.example.demo.service.thrift.User;
import com.example.demo.service.thrift.UserService;
import com.example.demo.service.thrift.UserService.Iface;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.thrift.TException;

/**
 * @author nut on 2018/12/19.
 */
@Service
public class WrapperServiceImpl implements WrapperService {

    @Resource
    private ApplicationConfig applicationConfig;

    @Resource
    private RegistryConfig registryConfig;


    @Override
    public int pure() {
        return 1;
    }

    @Override
    public int wrap() throws TException {

        Map<String, String> att = RpcContext.getContext().getAttachments();
        System.out.println(att);

        ReferenceBean<Iface> referenceBean = new ReferenceBean<>();
        referenceBean.setApplication(applicationConfig);
        referenceBean.setProtocol("thrift");
        referenceBean.setRegistry(registryConfig);
        referenceBean.setInterface(UserService.Iface.class);
        referenceBean.setCheck(true);
        referenceBean.setScope("remote");
        User u = referenceBean.get().getUserById(1);
        System.out.println(u);
        return 1;
    }

}
