package com.teamdev.brainfuck;


public class MoveBackwardCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        context.movePointerBackward();
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        context.movePointerBackward(count);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
