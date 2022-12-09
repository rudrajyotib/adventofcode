package aoc.y2022.Day8;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Day8PuzzleTest extends BaseTest {
    @Test
    public void shouldTestPuzzle1WithShortInput() throws IOException {
        assertEquals(21, new Day8Puzzle(generateCanonicalPathForResourceFile("y2022/D8Short.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle1WithLongInput() throws IOException {
        assertEquals(1662, new Day8Puzzle(generateCanonicalPathForResourceFile("y2022/D8Long.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle2WithShortInput() throws IOException {
        assertEquals(8, new Day8Puzzle(generateCanonicalPathForResourceFile("y2022/D8Short.txt")).solveP2());
    }

    @Test
    public void shouldTestPuzzle2WithLongInput() throws IOException {
        assertEquals(537600, new Day8Puzzle(generateCanonicalPathForResourceFile("y2022/D8Long.txt")).solveP2());
    }
}