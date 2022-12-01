package aoc.y2021.Day3;

public class BitCount {
    private int upCount=0;
    private int downCount = 0;

    public void incrementUpCount(){++this.upCount;}

    public void incrementDownCount(){++this.downCount;}

    public boolean dominantBit(){
        return this.upCount > this.downCount;
    }

    public boolean recessiveBit(){
        return this.downCount >= this.upCount;
    }

}
