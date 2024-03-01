import java.util.*;


public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }

        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */
//    public
    public int romanToInt(String s) {
        int sum = 0;
        int position;
        String[] specialCombination = {"IV", "IX", "XL", "XC", "CD", "CM"};
        int[] numOfFrequences = {0, 0, 0, 0, 0, 0};
        int[] values = {4, 9, 40, 90, 400, 900};
        for (int i = 0; i < 6; i++) {
            String nextPart = s;
            position = nextPart.indexOf(specialCombination[i]);

            while (position != -1) {
                numOfFrequences[i]++;
                nextPart = nextPart.substring(position + 2);
                position = nextPart.indexOf(specialCombination[i]);
            }
            s = s.replace(specialCombination[i], "0");
            sum += numOfFrequences[i] * values[i];
        }
        return normalSum(s, sum);

    }

    public int normalSum(String s, int sum) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */
    public static List<List<Integer>> InsertIndex(int numOfIndice, int indexToInsert, List<List<Integer>> mainList) {
        List<List<Integer>> tempList = new LinkedList<>();
        for (List<Integer> listToBeingInserted : mainList) {
            List<Integer> tempListToBeingInserted = listToBeingInserted ;
            for (int insertPlace = 0; insertPlace <= numOfIndice; insertPlace++) {
                listToBeingInserted.add(insertPlace, indexToInsert);
                tempList.add(listToBeingInserted);
//                listToBeingInserted.remove(insertPlace);
                listToBeingInserted = tempListToBeingInserted;
            }
        }
        mainList = tempList;

        return mainList;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mainList = new LinkedList<>();
        List<Integer> firstList = new LinkedList<>();
        firstList.add(nums[0]);
        mainList.add(firstList);
        int numOfIndice = nums.length;
        for (int i = 1; i < numOfIndice; i++) {         //the itereator begins from 1 because I manually added nums[0]
            int indexToInsert = nums[i];
            mainList = InsertIndex(i, indexToInsert, mainList);
        }
        return mainList;
    }

    public static void main(String[] args) {
        //******
        permute(new int[]{1, 2, 3});
//        for(List<Integer> i : permute(new int[] {1, 2, 3}){
//            for( Integer j : i){
//
//            }
//            System.out.println(i.toString());
//        }
//
    }
}
