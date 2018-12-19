package com.example.demo.service.dubbo;

import org.apache.thrift.TException;

/**
 * @author nut on 2018/12/19.
 */
public interface WrapperService {


    int pure();

    int wrap() throws TException;

}
