/**
 * Difficulty: Medium
 * find the k biggest number of arrays
 * first way to use partition like Quick Sort
 */

//partition
import java.util.Random;

class Solution {
    //random initialize
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        //target is the place of ans
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while(true){
            int ans = partition(nums,left,right);
            if(ans == target){
                return nums[ans];
            }else if(ans<target){
                left = ans + 1;
            }else if(ans > target){
                right = ans - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        //keep random to find pivot place to avoid extreme sort
        if(left<right){
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums,left,randomIndex);
        }
        int pivot = nums[left];
        int index = left;
        //sort like quick sort
        for(int i = left + 1; i <= right; i++){
            if(nums[i]<pivot){
                index++;
                swap(nums,i,index);
            }
        }
        swap(nums,index,left);
        //return the pivot place
        return index;
    }

    private void swap(int[]nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

}