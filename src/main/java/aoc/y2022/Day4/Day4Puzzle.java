package aoc.y2022.Day4;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day4Puzzle extends FileReaderEnabledPuzzleSolver {

    static class Pair{
        private final int left;
        private final int right;

        Pair(String line){
            String[] split = line.split("-");
            this.left = Integer.parseInt(split[0]);
            this.right = Integer.parseInt(split[1]);
        }

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean contains(Pair pair){
            if (this.left <= pair.left && this.right >= pair.right){
                return true;
            }
            return pair.left <= this.left && pair.right >= this.right;
        }

        public boolean overlaps(Pair pair){
            if (this.left >= pair.left && this.left <= pair.right){
               return true;
            }
            if (this.right >= pair.left && this.right <= pair.right){
                return true;
            }
            if (pair.left >= this.left && pair.left <= this.right){
                return true;
            }
            return pair.right >= this.left && pair.right <= this.right;
        }
    }



    public Day4Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solveP1() throws IOException {
        String line;
        int containCount = 0;
        while ((line= getBufferedReader().readLine()) != null){
            String[] split = line.split(",");
            Pair leftPair = new Pair(split[0]);
            Pair rightPair = new Pair(split[1]);
            if (leftPair.contains(rightPair)){
                ++containCount;
            }
        }

        return containCount;
    }

    public int solveP2() throws IOException {
        String line;
        int containCount = 0;
        while ((line= getBufferedReader().readLine()) != null){
            String[] split = line.split(",");
            Pair leftPair = new Pair(split[0]);
            Pair rightPair = new Pair(split[1]);
            if (leftPair.overlaps(rightPair)){
                ++containCount;
            }
        }

        return containCount;
    }
}
