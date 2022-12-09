package aoc.y2022.Day8;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Day8Puzzle extends FileReaderEnabledPuzzleSolver {

    public Day8Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }



    public int solveP1() throws IOException {
        String line ;
        List<String> lines = new LinkedList<>();
        while ((line= getBufferedReader().readLine())!=null){
            lines.add(line);
        }

        int[][] grid = new int[lines.size()][lines.get(0).length()];

       for (int i=0;i<grid.length;i++){
           for (int j=0;j<grid[0].length;j++){
               grid[i][j] = (lines.get(i).charAt(j)) - '0';
           }
       }

       int visible = 0;

       for (int i = 1;i<grid.length-1;i++){
           for (int j=1;j<grid[0].length-1;j++){
               if (!isTallestFromEdge(grid, i, j)){
                   ++visible;
               }
           }
       }

        return visible + (grid[0].length * 2) + ((grid.length-2)*2);
    }

    private int scenicScore(int[][] grid, int x, int y){

        int left= 0;
        int right= 0;
        int top= 0;
        int bottom= 0;


        for (int i=y-1;i>=0;i--){
            ++left;
            if (grid[x][i] >= grid[x][y]){
                break;
            }
        }

        for (int i=x-1;i>=0;i--){
            ++top;
            if (grid[i][y]>=grid[x][y]){
                break;
            }
        }

        for (int i=y+1;i<grid[0].length;i++){
            ++right;
            if (grid[x][i] >= grid[x][y]){
                break;
            }
        }

        for (int i=x+1;i<grid.length;i++){
            ++bottom;
            if (grid[i][y]>=grid[x][y]){
                break;
            }
        }

        return top * bottom * left * right;

    }


    private boolean isTallestFromEdge(int[][] grid, int x, int y){
      boolean visibleFromLeft = true;
      boolean visibleFromRight = true;
      boolean visibleFromTop = true;
      boolean visibleFromBottom = true;


        for (int i=0;i<y;i++){
            if (grid[x][i] >= grid[x][y]){
                visibleFromLeft = false;
                break;
            }
        }

        for (int i=0;i<x;i++){
            if (grid[i][y]>=grid[x][y]){
                visibleFromTop = false;
                break;
            }
        }

        for (int i=grid[0].length-1;i>y;i--){
            if (grid[x][i] >= grid[x][y]){
                visibleFromRight = false;
                break;
            }
        }

        for (int i=grid.length-1;i>x;i--){
            if (grid[i][y]>=grid[x][y]){
                visibleFromBottom = false;
                break;
            }
        }

        return !visibleFromLeft && !visibleFromRight && !visibleFromTop && !visibleFromBottom;

    }

    public int solveP2() throws IOException {
        String line ;
        List<String> lines = new LinkedList<>();
        while ((line= getBufferedReader().readLine())!=null){
            lines.add(line);
        }

        int[][] grid = new int[lines.size()][lines.get(0).length()];

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                grid[i][j] = (lines.get(i).charAt(j)) - '0';
            }
        }

        int maxScore = 0;

        for (int i = 1;i<grid.length-1;i++){
            for (int j=1;j<grid[0].length-1;j++){
                int scenicScore = scenicScore(grid, i, j);
                if (scenicScore > maxScore){
                    maxScore = scenicScore;
                }
            }
        }

        return maxScore;
    }
}
