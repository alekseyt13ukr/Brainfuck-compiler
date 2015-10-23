package com.teamdev.brainfuck;


public class PrintCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        System.out.print((char) context.getCurrentValue());
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print((char) context.getCurrentValue());
        }
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
