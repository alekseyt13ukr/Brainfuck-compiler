package com.teamdev.brainfuck;


public class DecrementCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        context.decrementCurrentValue();
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        context.decrementCurrentValue(count);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
