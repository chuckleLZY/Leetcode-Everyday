/**
 * difficulty: Easy
 * a merge sort
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] num = new int[m+n];
        while(i<m||j<n){
            if(i>=m){
                num[k++]=nums2[j++];
            }else if(j>=n){
                num[k++]=nums1[i++]; 
            }else if(nums1[i]<=nums2[j]){
                num[k++]=nums1[i++];
            }else{
                num[k++]=nums2[j++];
            }
        }
        for(int a=0;a<m+n;a++){
            nums1[a]=num[a];
        }
    }
}