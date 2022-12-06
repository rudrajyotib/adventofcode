package aoc.y2022.Day6;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Day6PuzzleTest extends BaseTest {
    @Test
    public void shouldTestPuzzle1WithShortInput() throws IOException {
        assertEquals(10, new Day6Puzzle(generateCanonicalPathForResourceFile("y2022/D6Short.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle1WithLongInput() throws IOException {
        assertEquals(1655, new Day6Puzzle(generateCanonicalPathForResourceFile("y2022/D6Long.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle2WithShortInput() throws IOException {
        assertEquals(29, new Day6Puzzle(generateCanonicalPathForResourceFile("y2022/D6Short.txt")).solveP2());
    }

    @Test
    public void shouldTestPuzzle2WithLongInput() throws IOException {
        assertEquals(2665, new Day6Puzzle(generateCanonicalPathForResourceFile("y2022/D6Long.txt")).solveP2());
    }
}