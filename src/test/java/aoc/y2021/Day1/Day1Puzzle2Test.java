package aoc.y2021.Day1;

import aoc.BaseTest;
import aoc.y2021.Day1.Day1Puzzle2;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day1Puzzle2Test extends BaseTest {


    @Test
    public void shouldCalculateSuccessHit() throws IOException {
        Day1Puzzle2 day1Puzzle2 = new Day1Puzzle2(generateCanonicalPathForResourceFile("y2021/D1P2.txt"));
        Assert.assertEquals(1252, day1Puzzle2.solve());
    }

}