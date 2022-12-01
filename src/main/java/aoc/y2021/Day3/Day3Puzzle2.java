package aoc.y2021.Day3;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day3Puzzle2 extends FileReaderEnabledPuzzleSolver {

    public Day3Puzzle2(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solve() throws IOException {
        BinaryBitsContainer binaryBitsContainer = new BinaryBitsContainer();
        String line;
        while ((line = getBufferedReader().readLine()) != null){
            binaryBitsContainer.addBinaryBits(new BinaryBits(line));
        }

        BinaryBits oxygenDecodeBit = binaryBitsContainer.choseDecodeBit(true, true);
        BinaryBits co2Bit = binaryBitsContainer.choseDecodeBit(false, false);
        return oxygenDecodeBit.convertToInt() * co2Bit.convertToInt();
    }
}
