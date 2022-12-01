package aoc.y2021.Day3;

import aoc.BaseTest;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class Day3Puzzle1Test extends BaseTest {

    @Test
    public void shouldFindEnginePower() throws IOException {
        Day3Puzzle1 day3Puzzle1 = new Day3Puzzle1(generateCanonicalPathForResourceFile("y2021/D3P1.txt"));
        assertEquals(3813416, day3Puzzle1.solve());
    }


}