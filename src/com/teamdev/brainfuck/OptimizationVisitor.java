package com.teamdev.brainfuck;

public class OptimizationVisitor implements CommandVisitor {

    private int counterRepeat = 0;

    private Command previousCommand;

    private ExecutionContext context;

    public OptimizationVisitor(ExecutionContext context) {
        this.context = context;
    }

    private void doVisit(Command command) {
        if (previousCommand == null || command.getClass() == previousCommand.getClass()) {
            counterRepeat++;
        } else {
            previousCommand.executeNTimes(context, counterRepeat);
            counterRepeat = 0;
        }
        previousCommand = command;
    }

    @Override
    public void visit(MoveForwardCommand command) {
        if (command == null) {
            System.out.println("Move Forward Command is null");
            return;
        }

        doVisit(command);
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        if (command == null) {
            System.out.println("Move Backward Command is null");
            return;
        }

        doVisit(command);
    }

    @Override
    public void visit(IncrementCommand command) {
        if (command == null) {
            System.out.println("Increment Command is null");
            return;
        }

        doVisit(command);
    }

    @Override
    public void visit(DecrementCommand command) {
        if (command == null) {
            System.out.println("Dercement Command is null");
            return;
        }

        doVisit(command);
    }

    @Override
    public void visit(PrintCommand command) {
        if (command == null) {
            System.out.println("Print Command is null");
            return;
        }

        doVisit(command);
    }

    @Override
    public void visit(LoopCommand command) {
        if (command == null) {
            System.out.println("Loop Command is null");
            return;
        }

//        command.execute(context);
        counterRepeat = 0;
        previousCommand = null;
        doVisit(command);

    }
}
