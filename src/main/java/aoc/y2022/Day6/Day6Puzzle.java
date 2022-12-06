package aoc.y2022.Day6;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day6Puzzle extends FileReaderEnabledPuzzleSolver {
    public Day6Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solveP1() throws IOException {
        return decode(getBufferedReader().readLine(), 4);
    }

    public int solveP2() throws IOException {
        return decode(getBufferedReader().readLine(), 14);
    }

    private int decode(String line, int uniqueCharCount) {
        int[] charCount = new int[26];
        for (int i = 0; i < uniqueCharCount; i++) {
            char present = line.charAt(i);
            ++charCount[present - 'a'];
        }
        if (markedChars(charCount) == uniqueCharCount) {
            return uniqueCharCount;
        }
        for (int i = uniqueCharCount; i < line.length(); i++) {
            --charCount[line.charAt(i - uniqueCharCount) - 'a'];
            ++charCount[line.charAt(i) - 'a'];
            if (markedChars(charCount) == uniqueCharCount) {
                return i + 1;
            }
        }
        return -1;
    }

    private int markedChars(int[] inputArray) {
        int count = 0;
        for (int element : inputArray) {
            if (element > 0) {
                ++count;
            }
        }
        return count;
    }
}
