package com.hujingli.design.command;

public class InsertCommand extends Command {
    Content c;
    String msg = "插入msg";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.setMsg(c.getMsg() + msg);
    }

    @Override
    public void undo() {
        c.setMsg(c.getMsg().substring(0, c.getMsg().length() - msg.length()));
    }
}
