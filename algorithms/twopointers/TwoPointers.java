package twopointers;

public class TwoPointers {

    /*
     * DESCRIPTION
     * Given a sorted array of integers nums, determine if there exists a pair of
     * numbers that sum to a given target.
     * Example:
     * Input: nums = [1,3,4,6,8,10,13], target = 13
     * Output: True (3 + 10 = 13)
     * Input: nums = [1,3,4,6,8,10,13], target = 6
     * Output: False
     */

    // Brute force (O(n^2))
    /*
     * two-pointers i and j in a nested for-loop
     * to consider each pair in the input array,
     * for a total of O(n2) pairs considered.
     */
    public boolean isPairSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimize: Eliminate pairs (O(n))
    // 1. Sorted array
    // 2. Compare and move pointer in a way to elimate unnecessary pairs
    /*
     * We have a sorted array left <<< right
     * Pointers from 2 ends --> sum()
     * Compare sum() vs target():
     * If sum() > target() --> move right
     * If sum() < target() --> move left
     */

    public boolean isPairSumBetter(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return true;
            }
            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoPointers tp = new TwoPointers();
        System.out.println();
        int[] nums1 = { 1, 3, 4, 6, 8, 10, 13 };
        int target1 = 13;
        System.out.println("Pair sum for target " + target1 + ": " + tp.isPairSum(nums1, target1)); // Should print true

        int[] nums2 = { 1, 3, 4, 6, 8, 10, 13 };
        int target2 = 6;
        System.out.println("Pair sum for target " + target2 + ": " + tp.isPairSum(nums2, target2)); // Should print
                                                                                                    // false

        int[] nums3 = { 1, 3, 4, 6, 8, 10, 13 };
        int target3 = 13;
        System.out.println("Pair sum for target " + target3 + ": " + tp.isPairSumBetter(nums3, target3)); // Should
                                                                                                          // print true

        int[] nums4 = { 1, 3, 4, 6, 8, 10, 13 };
        int target4 = 6;
        System.out.println("Pair sum for target " + target4 + ": " + tp.isPairSumBetter(nums4, target4)); // Should
                                                                                                          // print

    }

    /*
     * When Do I Use This?
     * Consider using the two-pointer technique for questions
     * that involve searching for a pair (or more) of items in an array
     * that meet a certain criteria.
     * Examples:
     * Finding a pair of items that sum to a given target in an array.
     * Finding a triplet of items that sum to 0 in a given array.
     * Finding the maximum amount of water that can be held
     * between two array items representing wall heights.
     */
}
