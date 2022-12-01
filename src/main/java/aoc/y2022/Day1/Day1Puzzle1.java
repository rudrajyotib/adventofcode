package aoc.y2022.Day1;

import java.io.IOException;
import java.util.Optional;

public class Day1Puzzle1 extends ElfFeeder {

    public Day1Puzzle1(String fileName) throws IOException {
        super(fileName);
    }

    public int solve() throws IOException {

        Optional<Elf> max = this.getAllElves().stream().max(Elf::compareTo).stream().findFirst();
        return max.map(Elf::getTotalCalories).orElse(-1);
    }

}
