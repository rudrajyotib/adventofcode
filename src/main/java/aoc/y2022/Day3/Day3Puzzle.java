package aoc.y2022.Day3;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day3Puzzle extends FileReaderEnabledPuzzleSolver {

    public Day3Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    private int getCharIndexInAlphabet(char x) {
        return (x >= 65 && x <= 90) ? 26 + x - 'A' : x - 'a';
    }

    public int solveP1() throws IOException {

        String line;

        int score = 0;
        while ((line = getBufferedReader().readLine()) != null) {
            boolean[][] presenceOfChars = new boolean[2][52];
            int half = line.length() / 2;
            for (int i = 0; i < half; i++) {
                presenceOfChars[0][getCharIndexInAlphabet(line.charAt(i))] = true;
                presenceOfChars[1][getCharIndexInAlphabet(line.charAt(half + i))] = true;
            }

            for (int i = 0; i < 52; i++) {
                if (presenceOfChars[0][i] && presenceOfChars[1][i]) {
                    score += (i + 1);
                }
            }
        }
        return score;
    }

    public int solveP2() throws IOException {

        String line1;
        int score = 0;
        while ((line1 = getBufferedReader().readLine()) != null) {
            String[] lines = new String[3];
            lines[0] = line1;
            lines[1] = getBufferedReader().readLine();
            lines[2] = getBufferedReader().readLine();

            boolean[][] presence = new boolean[3][52];

            for (int i = 0; i < 3; i++) {
                String l = lines[i];
                for (int j = 0; j < l.length(); j++) {
                    presence[i][getCharIndexInAlphabet(lines[i].charAt(j))] = true;
                }

            }

            for (int i = 0; i < 52; i++) {
                if (presence[0][i] && presence[1][i] && presence[2][i]) {
                    score += (1 + i);
                }
            }
        }
        return score;
    }
}
