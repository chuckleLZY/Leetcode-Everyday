
import java.util.PriorityQueue;

/**
 * Difficulty: Easy
 * find k small numbers of array
 * Use maxheap
 */
class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        //the answer array
        int[] ans = new int[k];
        if(k==0)return ans;
        //a maxheap capacity of k 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,(a,b)->b-a);
        for(int i=0;i<k;i++){
            maxHeap.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(maxHeap.peek()>arr[i]){//get the top heap number
                maxHeap.poll();//delete the top of heap
                maxHeap.offer(arr[i]);//add a new number to heap
            }
        }
        for(int i=0;i<k;i++){
            ans[i]=maxHeap.poll();
        }
        return ans;
    }
}