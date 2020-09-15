package com.hujingli.design.command;

public class DeleteCommand extends Command {

    Content c;
    String msg;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        msg = c.getMsg().substring(0, 2);
        c.setMsg(c.getMsg().substring(2));
    }

    @Override
    public void undo() {
        c.setMsg(msg + c.getMsg());
    }
}
