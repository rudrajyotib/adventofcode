package aoc.y2021.Day2;

import aoc.BaseTest;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class Day2Puzzle2Test extends BaseTest {

    @Test
    public void shouldCalculateDepth() throws IOException {
        Day2Puzzle2 day2Puzzle2 = new Day2Puzzle2(generateCanonicalPathForResourceFile("y2021/D2P2.txt"));
        assertEquals(1765720035, day2Puzzle2.solve());
    }


}