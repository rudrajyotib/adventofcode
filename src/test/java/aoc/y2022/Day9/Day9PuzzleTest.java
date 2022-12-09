package aoc.y2022.Day9;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Day9PuzzleTest extends BaseTest {

    @Test
    public void shouldSolveP1Short() throws IOException {
        assertEquals(13, new Day9Puzzle(generateCanonicalPathForResourceFile("y2022/D9P1Short.txt")).solveP1());
    }

    @Test
    public void shouldSolveP1Long() throws IOException {
        assertEquals(6470, new Day9Puzzle(generateCanonicalPathForResourceFile("y2022/D9Long.txt")).solveP1());
    }

    @Test
    public void shouldSolveP2Short() throws IOException {
        assertEquals(36, new Day9Puzzle(generateCanonicalPathForResourceFile("y2022/D9P2Short.txt")).solveP2());
    }

    @Test
    public void shouldSolveP2Long() throws IOException {
        assertEquals(2658, new Day9Puzzle(generateCanonicalPathForResourceFile("y2022/D9Long.txt")).solveP2());
    }


}