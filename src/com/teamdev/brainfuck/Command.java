package com.teamdev.brainfuck;

public interface Command {
    void execute(ExecutionContext context);

    void executeNTimes(ExecutionContext context, int count);

    void accept(CommandVisitor visitor);
}
