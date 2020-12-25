import java.util.Stack;

public class BBCandyCrush1D {

    public static void main(String[] args) {

        System.out.println(CandyCrush1D("aaabbbc"));
        System.out.println(CandyCrush1D("aabbbacd"));
        System.out.println(CandyCrush1D("aabbccddeeedcba"));
        System.out.println(CandyCrush1D("aaabbbacd"));
    }

    public static String CandyCrush1D(String s){

        Stack<Character> stack = new Stack();
        Stack<Integer> count = new Stack();

        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            if(stack.isEmpty() || c!=stack.peek()){
                if(!stack.isEmpty() && count.peek()>=3){
                    stack.pop();
                    count.pop();
                }else{
                    stack.push(c);
                    count.push(1);
                    i++;
                }
            }else{
                int currCount = count.pop();
                count.push(currCount+1);
                i++;
            }
        }

        if(stack.peek()>=3){
            stack.pop();
            count.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char c = stack.pop();
            int currentCount = count.pop();
            while(currentCount > 0){
                sb.append(c);
                currentCount--;
            }
        }

        return sb.reverse().toString();

    }
}
