package com.ysh.demo.handler.impl;

import com.ysh.demo.handler.Chain;

public class ZeroGreaterThanValidator extends Chain {


    @Override
    public boolean process(Object object) {

        if (object instanceof Number) {
            if ((Long) object <= 0) {
                return true;
            }
        }
        return false;
    }
}
