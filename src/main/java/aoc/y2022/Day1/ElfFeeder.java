package aoc.y2022.Day1;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ElfFeeder extends FileReaderEnabledPuzzleSolver {

    private final LinkedList<Elf> elves;

    public ElfFeeder(String fileName) throws IOException {
        super(fileName);
        elves = new LinkedList<>();
        createElves();
    }

    public List<Elf> getAllElves() {
        return this.elves;
    }

    private void createElves() throws IOException {
        String line = this.getBufferedReader().readLine();
        elves.addLast(new Elf());
        if (!line.isEmpty()) {
            elves.getLast().addCalorie(Integer.parseInt(line));
        }
        while ((line = this.getBufferedReader().readLine()) != null) {
            if (line.isEmpty()) {
                elves.addLast(new Elf());
            } else {
                elves.getLast().addCalorie(Integer.parseInt(line));
            }
        }
    }


}
