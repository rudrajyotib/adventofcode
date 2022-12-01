package aoc.y2021.Day3;

public class BinaryBits {

    private final boolean[] bits;

    public BinaryBits(String bitStream){
        this.bits = new boolean[bitStream.length()];
        for (int i=0;i<bitStream.length();i++){
            this.bits[i] = bitStream.charAt(i) == '1';
        }
    }

    public int convertToInt(){
        int number = 0;
        for (int i=bits.length-1;i>=0;i--){
            number += Math.pow(2, (bits.length-1-i)) * (bits[i] ? 1 : 0);
        }
        return number;
    }

    public int bitLength(){return bits.length;}

    public boolean bitAtIndex(int index){
        return this.bits[index];
    }


}
