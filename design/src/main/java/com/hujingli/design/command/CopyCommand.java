package com.hujingli.design.command;

public class CopyCommand extends Command {
    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.setMsg(c.getMsg() + c.getMsg());
    }

    @Override
    public void undo() {
        c.setMsg(c.getMsg().substring(0, c.getMsg().length() / 2));
    }
}
