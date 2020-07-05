package com.ysh.demo.handler.impl;

import com.ysh.demo.handler.Chain;

public class StringEmptyValidator extends Chain {
    private final String EMPTY_STRING = "";

    @Override
    public boolean process(Object object) {

        if (EMPTY_STRING.equals(object)) {
            return true;
        }
        return false;
    }
}
