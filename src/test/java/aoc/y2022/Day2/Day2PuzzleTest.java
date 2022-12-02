package aoc.y2022.Day2;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day2PuzzleTest extends BaseTest {

    @Test
    public void shouldSolveP1ShortInput() throws IOException {
        assertEquals(15, new Day2Puzzle(generateCanonicalPathForResourceFile("y2022/D2Short.txt")).solveP1());
    }

    @Test
    public void shouldSolveP2ShortInput() throws IOException {
        assertEquals(12, new Day2Puzzle(generateCanonicalPathForResourceFile("y2022/D2Short.txt")).solveP2());
    }

    @Test
    public void shouldSolveP1LongInput() throws IOException {
        assertEquals(11666, new Day2Puzzle(generateCanonicalPathForResourceFile("y2022/D2Long.txt")).solveP1());
    }

    @Test
    public void shouldSolveP2LongInput() throws IOException {
        assertEquals(12767, new Day2Puzzle(generateCanonicalPathForResourceFile("y2022/D2Long.txt")).solveP2());
    }


}