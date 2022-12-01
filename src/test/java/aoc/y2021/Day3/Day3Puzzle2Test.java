package aoc.y2021.Day3;

import aoc.BaseTest;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class Day3Puzzle2Test extends BaseTest {

    @Test
    public void shouldSolve() throws IOException {
        Day3Puzzle2 day3Puzzle2 = new Day3Puzzle2(generateCanonicalPathForResourceFile("y2021/D3P2.txt"));
        assertEquals(2990784, day3Puzzle2.solve());
    }

}