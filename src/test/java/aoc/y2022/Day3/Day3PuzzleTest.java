package aoc.y2022.Day3;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day3PuzzleTest extends BaseTest {

    @Test
    public void shouldSolveP1WithShortInput() throws IOException {
        assertEquals(157, new Day3Puzzle(generateCanonicalPathForResourceFile("y2022/D3Short.txt")).solveP1());
    }

    @Test
    public void shouldSolveP1WithLongInput() throws IOException {
        assertEquals(8394, new Day3Puzzle(generateCanonicalPathForResourceFile("y2022/D3Long.txt")).solveP1());
    }

    @Test
    public void shouldSolveP2WithShortInput() throws IOException {
        assertEquals(70, new Day3Puzzle(generateCanonicalPathForResourceFile("y2022/D3Short.txt")).solveP2());
    }

    @Test
    public void shouldSolveP2WithLongInput() throws IOException {
        assertEquals(2413, new Day3Puzzle(generateCanonicalPathForResourceFile("y2022/D3Long.txt")).solveP2());
    }



}