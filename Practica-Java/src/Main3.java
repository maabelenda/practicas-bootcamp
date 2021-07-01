import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Main3 {
    public static void main(String [] args) {

        Integer [] iArr = {2,504,20,3,55,31,24,106,100};

        //Shuffle array
        List<Integer> intList = Arrays.asList(iArr);
        Collections.shuffle(intList);

        intList.toArray(iArr);

        System.out.println(Arrays.toString(iArr));
        System.out.println("Sorted by RadixSort: ");
        System.out.println(Arrays.toString(radixSort(iArr)));
    }

    public static String [] radixSort(Integer [] iArr) {

        String [] sArr = new String[iArr.length];

        //get Max
        Integer max = Arrays.stream(iArr).max((x,y) -> x-y).get();
        Integer maxNumberLength = max.toString().length();

        //change int to string and add zeros at left
        for(int i = 0 ; i < iArr.length ; i++) {
            sArr[i] = StringUtils.leftPad(String.valueOf(iArr[i]), maxNumberLength,"0");
        }

        //radixSort Algorithm
        for(int i = maxNumberLength-1 ; i >= 0  ; i--) {
            Map<Character, List<String>> mapSorter = new HashMap<>();
            for(String s : sArr) {

                if(mapSorter.containsKey(s.charAt(i))) {
                    List<String> listSort = mapSorter.get(s.charAt(i));
                    listSort.add(s);
                    mapSorter.put(s.charAt(i), listSort);
                } else {
                    List<String> listSort = new ArrayList<>();
                    listSort.add(s);
                    mapSorter.put(s.charAt(i), listSort);
                }

            }
            List<String> newSArr = new ArrayList<>();
            for(List<String> l : mapSorter.values()) {
                newSArr.addAll(l);
            }
            newSArr.toArray(sArr);
        }

        return sArr;
    }
}
