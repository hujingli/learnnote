package com.hujingli.design.command;

public class CopyReceiver extends Receiver {

    private final Content c;

    public CopyReceiver(Content c) {
        this.c = c;
    }

    @Override
    protected void doSomething() {
        this.c.setMsg(this.c.getMsg() + this.c.getMsg());
    }
}
