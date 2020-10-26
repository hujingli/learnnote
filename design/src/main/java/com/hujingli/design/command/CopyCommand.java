package com.hujingli.design.command;

public class CopyCommand extends Command {

    private final Content c;

    public CopyCommand(Content c) {
        super(new CopyReceiver(c));
        this.c = c;
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }

    @Override
    public void undo() {
        c.setMsg(c.getMsg().substring(0, c.getMsg().length() / 2));
    }
}
