/**
 * Difficulty: Medium
 * use StringBuilder to do the multiply formula
 * use StringBuilder like a stack and finally just reverse it
 * keep remembering String.length(),not the String.length
 */
class Solution {
    public String multiply(String num1, String num2) {
        //if have zero, return zero
         if(num1.equals("0")||num2.equals("0")){
             return "0";
         }
         //change num1 to int
         int[] temp1 = new int[num1.length()];
         for(int i=0;i<num1.length();i++){
             temp1[i] = (int)(num1.charAt(i) - '0');
         }
         //the answer
         String temp_ans = "0";
         for(int i=num2.length()-1;i>=0;i--){
             //tempString to record the ans
             StringBuilder temp = new StringBuilder();
             //record each carry number
             int carry = 0;
             //insert the zero
             for(int j = 0; j<num2.length()-1-i;j++){
                 temp.append("0");
             }
             //calculate
             int x = (int)(num2.charAt(i) - '0');
             int y = 0;
             //carry>0 means ans.length()>Max(num1,length(),num2.length)
             for(int k=num1.length()-1;k>=0||carry>0;k--){
                 y = k<0? carry:(temp1[k]*x+carry)%10;
                 temp.append(y);
                 carry =k<0? 0: (temp1[k]*x+carry)/10;
             }
             //reverse temp to get the true ans and add them
             temp_ans = addString(temp_ans,temp.reverse().toString());
 
         }
         return temp_ans;
     }
 
     private String addString(String num1,String num2){
         StringBuilder temp = new StringBuilder();
         //record each carry number
         int carry=0;
         //be careful the carry number 
         for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0||carry>0;i--,j--){
             int x = i<0 ? 0: num1.charAt(i)-'0';
             int y = j<0 ? 0: num2.charAt(j)-'0';
             int ans = (x+y+carry)%10;
             temp.append(ans);
             carry = (x+y+carry)/10;
         }
         //reverse the ans
         return temp.reverse().toString();
     }
 
 
 }