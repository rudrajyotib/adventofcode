package aoc.y2021.Day3;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day3Puzzle1 extends FileReaderEnabledPuzzleSolver {


    public Day3Puzzle1(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solve() throws IOException {
        String line = getBufferedReader().readLine();
        BitConverter bitConverter = new BitConverter(line.length());
        int encryptLineLength = line.length();
        boolean[] gamma = new boolean[line.length()];
        boolean[] epsilon = new boolean[line.length()];
        bitConverter.addToBitCount(line);
        while ((line = getBufferedReader().readLine()) != null){
            bitConverter.addToBitCount(line);
        }
        for (int i=0;i<encryptLineLength;i++){
            gamma[i] = bitConverter.dominantBitAtIndex(i);
            epsilon[i] = bitConverter.recessiveBitAtIndex(i);
        }
        return bitConverter.convertToInt(gamma) * bitConverter.convertToInt(epsilon);

    }

}
