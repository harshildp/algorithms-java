/* Permutations
Given an Array of distinct integers, generate a list of all permutations from the array.
*/

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }

    // Create master list and start the recursive call
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        generatePermutations(ret, new ArrayList<>(), nums);
        return ret;
    }
    
    public static void generatePermutations(List<List<Integer>> ret, List<Integer> temp, int[] nums) {

        // If all the possible numbers have been used, add the list to the master list.
        if (temp.size() == nums.length) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        
        // Loop through the possible numbers and recurse with them added to the temp list one by one 
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            
            temp.add(nums[i]);
            generatePermutations(ret, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}