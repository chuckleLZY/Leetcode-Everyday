/**
 * Difficulty: Medium
 * Use QuickSort to sort the array
 */

import java.util.Random;
class Solution {
    private Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        QuickSort(nums,0,nums.length-1);
        return nums;
    }

    private void QuickSort(int[] nums, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = left + random.nextInt(right - left);
        swap(nums,left,pivot);
        pivot = nums[left];
        int node = left;
        for(int i = left + 1; i<=right;i++){
            if(nums[i]<pivot){
                node++;
                swap(nums,i,node);
            }
        }
        swap(nums,left,node);
        QuickSort(nums,left,node-1);
        QuickSort(nums,node+1,right);
    }
    private void swap(int[] nums, int num1, int num2){
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}