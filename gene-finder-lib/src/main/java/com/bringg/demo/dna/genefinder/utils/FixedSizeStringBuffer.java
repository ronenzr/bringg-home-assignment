package com.bringg.demo.dna.genefinder.utils;

public class FixedSizeStringBuffer {
    private int fixedCapacity;
    private StringBuffer buffer;

    public FixedSizeStringBuffer(int fixedCapacity) {
        this.fixedCapacity = fixedCapacity;
        this.buffer = new StringBuffer(fixedCapacity);
    }

    public void append(char ch) {
        if (buffer.length() + 1 > fixedCapacity) {
            buffer.deleteCharAt(0);
        }
        buffer.append(ch);
    }

    public boolean compare(String toCompare) {
        return buffer.toString().equals(toCompare);
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
