package aoc.y2021.Day3;

public class BitConverter {

    private final BitCount[] bitCounts;

    public BitConverter(int binaryInputSize){
        this.bitCounts = new BitCount[binaryInputSize];
        for (int i=0;i<binaryInputSize;i++){
            this.bitCounts[i] = new BitCount();
        }
    }

    public void addToBitCount(String binaryInput){
        for (int i=0;i<binaryInput.length();i++){
            if ('0' == binaryInput.charAt(i)){
                bitCounts[i].incrementDownCount();
            }else{
                bitCounts[i].incrementUpCount();
            }
        }
    }

    public boolean dominantBitAtIndex(int index){
        return this.bitCounts[index].dominantBit();
    }

    public boolean recessiveBitAtIndex(int index){
        return this.bitCounts[index].recessiveBit();
    }

    public int convertToInt(boolean[] bits){
        int number = 0;
        for (int i=bits.length-1;i>=0;i--){
            number += Math.pow(2, (bits.length-1-i)) * (bits[i] ? 1 : 0);
        }
        return number;
    }



}
