package com.teamdev.brainfuck;

public class ExecutionContext {

    public static final int MEMORY_SIZE = 30000;

    private final byte[] memory = new byte[MEMORY_SIZE];
    private int pointer;

    public void movePointerForward(int count) {
        pointer += count;

        if (pointer >= MEMORY_SIZE) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public void movePointerForward() {
        movePointerForward(1);
    }

    public void movePointerBackward(int count) {
        pointer -= count;

        if (pointer < 0) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public void movePointerBackward() {
        movePointerBackward(1);
    }

    public byte getCurrentValue() {
        return memory[pointer];
    }

    public void incrementCurrentValue(int count) {
        memory[pointer] += count;
    }

    public void incrementCurrentValue() {
        memory[pointer]++;
    }

    public void decrementCurrentValue(int count) {
        memory[pointer] -= count;
    }

    public void decrementCurrentValue() {
        memory[pointer]--;
    }

}
