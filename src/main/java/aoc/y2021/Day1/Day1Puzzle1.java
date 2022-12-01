package aoc.y2021.Day1;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.*;

public class Day1Puzzle1 extends FileReaderEnabledPuzzleSolver {

    public Day1Puzzle1(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solve() throws IOException {


        String firstLine = getBufferedReader().readLine();

        int previousDepth = Integer.parseInt(firstLine);
        int increaseCount = 0;

        while ((firstLine=getBufferedReader().readLine()) != null){
            int currentDepth = Integer.parseInt(firstLine);
            if (currentDepth > previousDepth){
                ++increaseCount;
            }
            previousDepth = currentDepth;
        }


        return increaseCount;
    }


}
