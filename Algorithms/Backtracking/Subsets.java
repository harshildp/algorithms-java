/* Subsets
Given an Array of distinct integers, generate a list of all possible subsets from the array.
*/

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }

    // Create master list and start the recursive call
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        generateSubsets(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    
    public static void generateSubsets(List<List<Integer>> ret, List<Integer> temp, int[] nums, int start) {

        // Always add the temp list to the master list.
        ret.add(new ArrayList<>(temp));
        
        // Loop through the possible numbers and recurse with them added to the temp list one by one 
        for (int i = start; i < nums.length; i++) {            
            temp.add(nums[i]);
            generateSubsets(ret, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}