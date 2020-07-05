package com.ysh.demo.handler.impl;

import com.ysh.demo.handler.Chain;

public class ObjectNullValidator extends Chain {

    @Override
    public boolean process(Object object) {

        if (object == null) {
            //throw new Exception("object is null");
            return true;
        }
        return false;
    }
}
