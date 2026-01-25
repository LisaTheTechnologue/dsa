package twopointers;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    /*
     * https://leetcode.com/problems/3sum/description/
     * Given an integer array nums,
     * return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k,
     * and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not
     * matter.
     * Example 2:
     * 
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     * 
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        return list;
    }

    public void printList(List<List<Integer>> list) {
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ThreeSum cmw = new ThreeSum();
        System.out.println();
        int[] heights1 = { -1, 0, 1, 2, -1, -4 };
        // int width1 = 7, height1 = 3, area1 = 21;
        // print
        cmw.printList(cmw.threeSum(heights1));

        int[] heights2 = { 0, 1, 1 };
        // int width2 = 2, height2 = 1, area2 = 2;
        cmw.printList(cmw.threeSum(heights1));

        int[] heights3 = { 0, 0, 0 };
        // int width1 = 7, height1 = 3, area1 = 21;
        // print
        cmw.printList(cmw.threeSum(heights1));

    }
}
