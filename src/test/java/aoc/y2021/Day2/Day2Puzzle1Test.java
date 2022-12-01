package aoc.y2021.Day2;

import aoc.BaseTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day2Puzzle1Test extends BaseTest {

    @Test
    public void shouldCalculateFinalPosition() throws IOException {
        Day2Puzzle1 day2Puzzle1 = new Day2Puzzle1(generateCanonicalPathForResourceFile("y2021/D2P1.txt"));
        assertEquals(1728414, day2Puzzle1.solve());
    }


}