package aoc.y2021.Day1;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Day1Puzzle2 extends FileReaderEnabledPuzzleSolver {

    public Day1Puzzle2(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solve() throws IOException {


        int increaseCount = 0;

        Queue<Integer> startNumberAtHeadQueue = new LinkedList<>();
        int sumAtLastElement = 0;
        for (int i=1;i<=3;i++){
            int element = Integer.parseInt(getBufferedReader().readLine());
            sumAtLastElement += element;
            startNumberAtHeadQueue.add(element);
        }



        String firstLine;

        while ((firstLine=getBufferedReader().readLine()) != null){
            int currentDepth = Integer.parseInt(firstLine);
            int elementToRemove = startNumberAtHeadQueue.remove();
            int tempSumAtDepth = sumAtLastElement - elementToRemove + currentDepth;
//            System.out.printf("Received %d, removing %d, sum was %d, sum is %d\n", currentDepth, elementToRemove, sumAtLastElement, tempSumAtDepth);
            if (tempSumAtDepth > sumAtLastElement){
                ++increaseCount;
            }
            sumAtLastElement = tempSumAtDepth;
            startNumberAtHeadQueue.add(currentDepth);
        }


        return increaseCount;
    }


}
