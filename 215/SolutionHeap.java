/**
 * Difficulty: Medium
 * find the k biggest number of arrays
 * second way to use minheap
 */
//minheap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //set a minheap whose capacity is k
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k,(a,b)->a-b);
        //add k elements in minheap
        for(int i=0;i<k;i++){
            minheap.offer(nums[i]);
        }
        //add k of the biggest numbers of the array
        for(int i=k;i<nums.length;i++){
            if(minheap.peek()<nums[i]){
                minheap.poll();
                minheap.offer(nums[i]);
            }
        }
        //the kth biggest number of array is on the top of the minheap
        return minheap.poll();
    }
}