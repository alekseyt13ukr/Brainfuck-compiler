package com.teamdev.brainfuck;

import java.util.List;

public class LoopCommand implements Command {

    private final List<Command> innerCommands;

    public LoopCommand(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    @Override
    public void execute(ExecutionContext context) {

        while (context.getCurrentValue() != 0) {
            for (Command command : innerCommands) {
                command.execute(context);
            }
        }
    }

    @Override
    public void executeNTimes(ExecutionContext context, int count) {
        this.execute(context);
    }

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
//        for (Command command : innerCommands) {
//            command.accept(visitor);
//        }
    }

}
