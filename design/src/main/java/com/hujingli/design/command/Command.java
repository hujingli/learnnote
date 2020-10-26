package com.hujingli.design.command;

public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

    public abstract void undo();

}
