package org.numbers_reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class NumbersReader {
    private boolean isEmpty = true;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;
    private long mult = 1;
    private long sum = 0;

    public NumbersReader() {}

    public NumbersReader(final Path path) throws IOException {
        processFile(path);
    }

    public void processFile(final Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLong()) {
            processLong(scanner.nextLong());
        }
        scanner.close();
    }

    private void processLong(final long x) {
        isEmpty = false;
        min = Math.min(min, x);
        max = Math.max(max, x);
        sum += x;
        mult *= x;
    }

    public long _min() {
        return min;
    }

    public long _max() {
        return max;
    }

    public long _mult() {
        return mult;
    }

    public long _sum() {
        return sum;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
