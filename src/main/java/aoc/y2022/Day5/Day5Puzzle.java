package aoc.y2022.Day5;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5Puzzle extends FileReaderEnabledPuzzleSolver {

    private final List<Stack<Character>> stacks;
    private final List<String[]> instructions;


    public Day5Puzzle(String fileName) throws IOException {
        super(fileName);
        List<String> crates = new ArrayList<>();
        this.instructions = new ArrayList<>();
//        this.stacks = new ArrayList<>();
        String line;

        boolean allCratesParsed = false;
        int stackSize = 0;

        while ((!allCratesParsed)) {
            line = getBufferedReader().readLine();
            if (line.trim().startsWith("1")) {
                allCratesParsed = true;
                line = line.trim();
                String[] stackIndex = line.split(" {3}");
                stackSize = stackIndex.length;
            } else {
                crates.add(line);
            }
        }

        getBufferedReader().readLine();

        this.stacks = new ArrayList<>(stackSize);

        for (int i = 0; i < stackSize; i++) {
            //noinspection unchecked,rawtypes
            stacks.add(new Stack());
        }

        for (int i = crates.size() - 1; i >= 0; i--) {
            String crate = crates.get(i);
            for (int j = 0; j < stackSize; j++) {
                int nextCharPos = j * 4 + 1;
                if (nextCharPos < crate.length() && crate.charAt(j * 4 + 1) != ' ') {
                    stacks.get(j).push(crate.charAt(j * 4 + 1));
                }
            }
        }

        while ((line = getBufferedReader().readLine()) != null) {
            String[] instruction = line.split(" ");
            this.instructions.add(instruction);
        }

    }

    private String createStackTopView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Stack<Character> stack : this.stacks) {
            if (!stack.isEmpty()) {
                stringBuilder.append(stack.peek());
            }
        }
        return stringBuilder.toString();
    }


    public String solveP2() {
        for (String[] instruction : this.instructions) {
            moveInOrder(this.stacks.get(Integer.parseInt(instruction[3]) - 1),
                    this.stacks.get(Integer.parseInt(instruction[5]) - 1),
                    Integer.parseInt(instruction[1]));
        }
        return createStackTopView();
    }

    public String solveP1() {
        for (String[] instruction : this.instructions) {
            move(this.stacks.get(Integer.parseInt(instruction[3]) - 1),
                    this.stacks.get(Integer.parseInt(instruction[5]) - 1),
                    Integer.parseInt(instruction[1]));
        }
        return createStackTopView();
    }

    private void move(Stack<Character> from, Stack<Character> to, int count) {
        for (int i = 0; i < count; i++) {
            Character element = from.pop();
            to.push(element);
        }
    }

    private void moveInOrder(Stack<Character> from, Stack<Character> to, int count) {
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < count; i++) {
            Character element = from.pop();
//            to.push(element);
            tempStack.push(element);
        }
        while (!tempStack.isEmpty()) {
            to.push(tempStack.pop());
        }
    }


}
