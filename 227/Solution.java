/**
 * difficulty:Medium
 * use a stack to record the number
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char preSign = '+';
        int ans =0;
        int temp =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                temp = temp * 10 +s.charAt(i)-'0';
            }
            if((s.charAt(i)<'0'||s.charAt(i)>'9')&& s.charAt(i)!=' '|| i==s.length()-1){
                switch (preSign){
                    case '+':
                        stack.push(temp);
                        break;
                    case '-':
                        stack.push(-1*temp);
                        break;
                    case '*':
                        stack.push(stack.pop()*temp);
                        break;
                    case '/':
                        stack.push(stack.pop()/temp);
                        break;
                }
                preSign = s.charAt(i);
                temp =0;
            }
        }
        while(stack.isEmpty()==false){
            ans += stack.pop();
        }
        return ans;

    }
}