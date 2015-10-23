package com.teamdev.brainfuck;


public class MoveForwardCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        context.movePointerForward();
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        context.movePointerForward(count);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
