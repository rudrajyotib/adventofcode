package aoc.y2022.Day1;

import java.io.IOException;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Day1Puzzle2 extends ElfFeeder {

    public Day1Puzzle2(String fileName) throws IOException {
        super(fileName);
    }

    @SuppressWarnings("Convert2Lambda")
    public int solve() {
        //noinspection unchecked,Convert2Diamond,Anonymous2MethodRef
        return this.getAllElves()
                .stream().sorted(Comparator.reverseOrder()).limit(3)
                .mapToInt(new ToIntFunction<Elf>() {
                    @Override
                    public int applyAsInt(Elf value) {
                        return value.getTotalCalories();
                    }
                }).sum();
    }
}
