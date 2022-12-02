package aoc.y2022.Day2;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

enum Elements {
    Rock(1),
    Paper(2),
    Scissor(3);

    private final int weight;

    Elements(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}

enum Results {
    Loss(0),
    Draw(3),
    Win(6);

    private final int points;

    Results(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

public class Day2Puzzle extends FileReaderEnabledPuzzleSolver {

    private final Results[][] round_results_for_player2 = {
            {Results.Draw, Results.Win, Results.Loss},
            {Results.Loss, Results.Draw, Results.Win},
            {Results.Win, Results.Loss, Results.Draw}
    };

    private final Elements[][] round_results_reverse = {
            {Elements.Scissor, Elements.Rock, Elements.Paper},
            {Elements.Rock, Elements.Paper, Elements.Scissor},
            {Elements.Paper, Elements.Scissor, Elements.Rock}
    };

    private final Elements[] element_codes = {Elements.Rock, Elements.Paper, Elements.Scissor};
    private final Results[] results_codes = {Results.Loss, Results.Draw, Results.Win};

    public Day2Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solveP1() throws IOException {
        String line;

        int score = 0;
        while ((line = getBufferedReader().readLine()) != null) {
            String[] split = line.split(" ");
            Elements element = element_codes[split[1].charAt(0) - 'X'];
            score += element.getWeight();
            score += round_results_for_player2[split[0].charAt(0) - 'A'][split[1].charAt(0) - 'X'].getPoints();
        }

        return score;
    }

    public int solveP2() throws IOException {
        String line;

        int score = 0;
        while ((line = getBufferedReader().readLine()) != null) {
            String[] split = line.split(" ");
            Elements player2Option = round_results_reverse[split[0].charAt(0) - 'A'][split[1].charAt(0) - 'X'];
            score += player2Option.getWeight();
            score += results_codes[split[1].charAt(0) - 'X'].getPoints();
        }

        return score;
    }
}
