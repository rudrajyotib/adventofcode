package aoc.y2022.Day1;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day1Puzzle2Test extends BaseTest {

    @Test
    public void shouldSolveShort() throws IOException {
        assertEquals(45000, new Day1Puzzle2(generateCanonicalPathForResourceFile("y2022/D1Short.txt")).solve());
    }

    @Test
    public void shouldSolveLong() throws IOException {
        assertEquals(206643, new Day1Puzzle2(generateCanonicalPathForResourceFile("y2022/D1Long.txt")).solve());
    }


}