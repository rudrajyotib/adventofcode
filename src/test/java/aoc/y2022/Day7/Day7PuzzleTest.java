package aoc.y2022.Day7;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Day7PuzzleTest extends BaseTest {
    @Test
    public void shouldTestPuzzle1WithShortInput() throws IOException {
        assertEquals(95437, new Day7Puzzle(generateCanonicalPathForResourceFile("y2022/D7Short.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle1WithLongInput() throws IOException {
        assertEquals(1077191, new Day7Puzzle(generateCanonicalPathForResourceFile("y2022/D7Long.txt")).solveP1());
    }

    @Test
    public void shouldTestPuzzle2WithShortInput() throws IOException {
        assertEquals(24933642, new Day7Puzzle(generateCanonicalPathForResourceFile("y2022/D7Short.txt")).solveP2());
    }

    @Test
    public void shouldTestPuzzle2WithLongInput() throws IOException {
        assertEquals(5649896, new Day7Puzzle(generateCanonicalPathForResourceFile("y2022/D7Long.txt")).solveP2());
    }
}