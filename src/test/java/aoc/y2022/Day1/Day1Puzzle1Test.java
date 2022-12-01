package aoc.y2022.Day1;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day1Puzzle1Test extends BaseTest {

    @Test
    public void shouldSolveShort() throws IOException {
        Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1(generateCanonicalPathForResourceFile("y2022/D1Short.txt"));
        assertEquals(24000, day1Puzzle1.solve());
    }

    @Test
    public void shouldSolveLong() throws IOException {
        Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1(generateCanonicalPathForResourceFile("y2022/D1Long.txt"));
        assertEquals(70698, day1Puzzle1.solve());
    }
}