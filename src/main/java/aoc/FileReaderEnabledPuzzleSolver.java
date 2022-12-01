package aoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderEnabledPuzzleSolver {

    private final BufferedReader bufferedReader;

    public FileReaderEnabledPuzzleSolver(String fileName) throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new FileReader(fileName));
    }

    public BufferedReader getBufferedReader(){
        return this.bufferedReader;
    }
}
