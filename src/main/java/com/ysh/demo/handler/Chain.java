package com.ysh.demo.handler;

public abstract class Chain {

    private Chain nextChain;

    public Chain setNextChain(Chain newChain) {
        this.nextChain = newChain;
        return this.nextChain;
    }

    public abstract boolean process(Object object);

    public boolean validate(Object object) {


        boolean result = this.process(object);
        printLog(object, result);

        if (result) {
            System.out.println("검증 대상");
        } else {
            if (nextChain != null) {
                result = nextChain.validate(object);
            } else {
                System.out.println("------validate end------");
            }
        }

        return result;
    }

    private void printLog(Object object, boolean result) {
        System.out.println("[" + result + "][" + this.getClass().getSimpleName() + "] - value : " + object);
    }

}
