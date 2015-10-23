package com.teamdev.brainfuck;


public class IncrementCommand implements Command {

    @Override
    public void execute(ExecutionContext context) {
        context.incrementCurrentValue();
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        context.incrementCurrentValue(count);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
