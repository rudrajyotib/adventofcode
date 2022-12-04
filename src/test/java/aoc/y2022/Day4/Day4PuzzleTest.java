package aoc.y2022.Day4;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day4PuzzleTest extends BaseTest {

    @Test
    public void shouldTestPuzzle1WithShortInput() throws IOException {
        assertEquals(2, new Day4Puzzle(generateCanonicalPathForResourceFile("y2022/D4Short.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle1WithLongInput() throws IOException {
        assertEquals(576, new Day4Puzzle(generateCanonicalPathForResourceFile("y2022/D4Long.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle2WithShortInput() throws IOException {
        assertEquals(4, new Day4Puzzle(generateCanonicalPathForResourceFile("y2022/D4Short.txt")).solveP2());
    }

    @Test
    public void shouldTestPuzzle2WithLongInput() throws IOException {
        assertEquals(905, new Day4Puzzle(generateCanonicalPathForResourceFile("y2022/D4Long.txt")).solveP2());
    }

}