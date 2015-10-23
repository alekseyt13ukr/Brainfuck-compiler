package com.teamdev.brainfuck;

import java.util.*;

/**
 * Compiler for Brainfuck programming language.
 */
public class Compiler {

    public static final String PROGRAM = "++++++++[>++++[>++>+++>+++>+<<<<-]" +
            ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------" +
            ".>>+.>++.";

    public List<Command> compile(String program) {

        final Deque<List<Command>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<>());

        for (char c : program.toCharArray()) {

            switch (c) {
                case '>': {
                    stack.peek().add(new MoveForwardCommand());
                    break;
                }
                case '<': {
                    stack.peek().add(new MoveBackwardCommand());
                    break;
                }
                case '+': {
                    stack.peek().add(new IncrementCommand());
                    break;
                }
                case '-': {
                    stack.peek().add(new DecrementCommand());
                    break;
                }
                case '.': {
                    stack.peek().add(new PrintCommand());
                    break;
                }
                case '[': {
                    stack.push(new ArrayList<>());
                    break;
                }
                case ']': {

                    if (stack.size() < 2) {
                        throw new IllegalStateException("Unexpected right parenthesis.");
                    }

                    final LoopCommand loop = new LoopCommand(stack.pop());
                    stack.peek().add(loop);
                    break;
                }
                case ' ': {
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown command: " + c);

            }

        }

        if (stack.size() > 1) {
            throw new IllegalStateException("There are loops that are not closed.");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        final Compiler compiler = new Compiler();
        final List<Command> commandList = compiler.compile(PROGRAM);

        final ExecutionContext context = new ExecutionContext();

        final CommandVisitor visitor = new OptimizationVisitor(context);

        for (Command command : commandList) {
            command.accept(visitor);
        }
    }
}
