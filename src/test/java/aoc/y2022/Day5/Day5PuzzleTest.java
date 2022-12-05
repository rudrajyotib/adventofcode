package aoc.y2022.Day5;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day5PuzzleTest extends BaseTest {

    @Test
    public void shouldTestPuzzle1WithShortInput() throws IOException {
        assertEquals("CMZ", new Day5Puzzle(generateCanonicalPathForResourceFile("y2022/D5Short.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle1WithLongInput() throws IOException {
        assertEquals("SVFDLGLWV", new Day5Puzzle(generateCanonicalPathForResourceFile("y2022/D5Long.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle2WithShortInput() throws IOException {
        assertEquals("MCD", new Day5Puzzle(generateCanonicalPathForResourceFile("y2022/D5Short.txt")).solveP2());
    }

    @Test
    public void shouldTestPuzzle2WithLongInput() throws IOException {
        assertEquals("DCVTCVPCL", new Day5Puzzle(generateCanonicalPathForResourceFile("y2022/D5Long.txt")).solveP2());
    }
}