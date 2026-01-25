package twopointers;

public class ContainerMostWater {
    /*
     * DESCRIPTION
     * https://www.hellointerview.com/learn/code/two-pointers/container-with-most-
     * water
     * Given an array heights where each element represents the height of a vertical
     * line,
     * pick two lines to form a container.
     * Return the maximum area (amount of water) the container can hold.
     * 
     * What is area?
     * Width × height,
     * where width is the distance between walls,
     * and height is the shorter wall (water overflows at the shorter wall).
     */

    public Integer max_area(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public Integer max_area_better(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[right], heights[left]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerMostWater cmw = new ContainerMostWater();
        System.out.println();
        int[] heights1 = { 3, 4, 1, 2, 2, 4, 1, 3, 2 };
        // int width1 = 7, height1 = 3, area1 = 21;
        // print
        System.out.println("Max area 1: " + cmw.max_area(heights1));

        int[] heights2 = { 1, 2, 1 };
        // int width2 = 2, height2 = 1, area2 = 2;
        System.out.println("Max area 2: " + cmw.max_area(heights2));

        int[] heights3 = { 3, 4, 1, 2, 2, 4, 1, 3, 2 };
        // int width1 = 7, height1 = 3, area1 = 21;
        // print
        System.out.println("Max area 3: " + cmw.max_area_better(heights3));

        int[] heights4 = { 1, 2, 1 };
        // int width2 = 2, height2 = 1, area2 = 2;
        System.out.println("Max area 4: " + cmw.max_area_better(heights4));

    }

    /*
     * Understanding the Problem
     * Picture vertical lines on a graph—each line's height comes from the array.
     * You pick any two lines to act as the walls of a container (like a fish tank).
     * The "area" is simply how much water this container can hold.
     * 
     * What is area? Just width × height:
     * Width: How far apart the two walls are (right_index - left_index)
     * Height: The shorter wall's height (min(heights[left], heights[right]))
     * 
     * Why the shorter wall?
     * Imagine filling the container with water—it would overflow at the level of
     * the shorter wall.
     * If one wall is height 10 and the other is height 3,
     * water only fills up to height 3 before spilling over.
     * Area formula: width × min(left_height, right_height)
     * 
     * Why Does Two-Pointer Work Here?
     * Two-pointers are generally perceived to work on sorted arrays
     * and that's a common pattern, but not a strict rule.
     * Two-pointer works whenever we can eliminate possibilities by moving pointers
     * intelligently.
     * In this problem, the array isn't sorted—but we don't need it to be.
     * We start with the widest possible container (pointers at both ends)
     * and can eliminate suboptimal containers based on a simple observation:
     * moving the taller wall inward can never help us because:
     * The width decreases
     * The height is still limited by the shorter wall
     * So we always move the pointer pointing to the shorter wall, hoping to find a
     * taller one.
     */
}
