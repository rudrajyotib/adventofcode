package aoc.y2021.Day2;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day2Puzzle2 extends FileReaderEnabledPuzzleSolver {

    public Day2Puzzle2(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solve() throws IOException {

        String line;
        Position position = new Position(true);

        while ((line = getBufferedReader().readLine()) != null){
            String[] movements = line.split(" ");
            Command.valueOf(movements[0]).changePosition(position, Integer.parseInt(movements[1]));
        }

        return position.result();
    }

}


