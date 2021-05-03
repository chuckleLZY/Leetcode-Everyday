/**
 * Difficulty: Medium
 * odd line x decrease and y increase
 * even line x increase and x decrease
 */

//odd line x decrease and y increase
//even line x increase and x decrease
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        //set zero capacity answer
        if(mat.length==0||mat[0].length==0){
            return new int[1];
        }

        int M =mat.length;
        int N = mat[0].length;
        int[] ans = new int[M*N];

        int i=0,index=0;
        //judge if is odd
        boolean isOdd = true;
        while(i < M + N){
            if(isOdd){
                isOdd = false;
                int x1 = (i < M) ? i : M - 1;
                int y1 = i - x1;
                while(x1>=0 && y1<N){
                    ans[index++]=mat[x1--][y1++];
                }
            }else{
                isOdd = true;
                int y2 = (i < N) ? i : N - 1;
                int x2 = i - y2;
                while(y2 >=0 && x2 < M){
                    ans[index++] = mat[x2++][y2--];
                }
            }
            i++;
        }
        return ans;
    }
}