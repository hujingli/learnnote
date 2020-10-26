package com.hujingli.design.command;

public class Main {

    public static void main(String[] args) {
        Content c = new Content();


        CopyCommand copyCommand = new CopyCommand(c);
        Invoker invoker = new Invoker();
        invoker.setCommand(copyCommand);
        invoker.action();
        System.out.println(c.getMsg());

        copyCommand.undo();



        System.out.println(c.getMsg());
    }

}
