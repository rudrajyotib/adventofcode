package aoc.y2021.Day1;

import aoc.BaseTest;
import aoc.y2021.Day1.Day1Puzzle1;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day1Puzzle1Test extends BaseTest {

    @Test
    public void shouldCountSuccessHits() throws IOException {
        Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1(generateCanonicalPathForResourceFile("y2021/D1P1.txt"));
        Assert.assertEquals(1226, day1Puzzle1.solve());
    }


}