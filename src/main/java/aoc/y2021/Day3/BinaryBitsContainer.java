package aoc.y2021.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BinaryBitsContainer {

    private final List<BinaryBits> binaryBitsList;


    public BinaryBitsContainer() {
        binaryBitsList = new ArrayList<>();
    }

    public void addBinaryBits(BinaryBits bits){
        this.binaryBitsList.add(bits);
    }

    public BinaryBits choseDecodeBit(boolean dominantBit, boolean mostCommonCriteria){
        boolean singledOut = false;
        BinaryBits decodeBit = null;
        int index = 0;
        List<BinaryBits> list = this.binaryBitsList;

        while (!singledOut){
            boolean majorityBitAtIndex = mostCommonOrLeastCommonBitAtIndex(list, index, dominantBit, mostCommonCriteria);
            int indexForPredicate = index;
            list = list.stream().filter(bits -> majorityBitAtIndex == bits.bitAtIndex(indexForPredicate)).collect(Collectors.toList());
            ++index;
            if ((list.size() == 1) || (index == this.binaryBitsList.get(0).bitLength()) ){
                singledOut = true;
                decodeBit = list.get(0);
            }
        }

        return decodeBit;

    }

    private static boolean mostCommonOrLeastCommonBitAtIndex(final List<BinaryBits> binaryBitsList, int index, boolean dominantBit, boolean mostCommon){
        long filteredBitsCount = binaryBitsList.stream().filter(bits -> bits.bitAtIndex(index)).count();
        long unfilteredBitsCount = binaryBitsList.size() - filteredBitsCount;
        if (filteredBitsCount > unfilteredBitsCount){
            return mostCommon;
        }else if (filteredBitsCount == unfilteredBitsCount){
            return dominantBit;
        }else{
            return !mostCommon;
        }
    }
}
