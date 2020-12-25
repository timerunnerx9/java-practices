package GeneralProblems;

import java.util.Stack;

public class BBCandyCrush1DDave {

    public static void main(String[] args) {

        System.out.println(CandyCrush1D("aaabbbc"));
        System.out.println(CandyCrush1D("aabbbacd"));
        System.out.println(CandyCrush1D("aabbccddeeedcba"));
        System.out.println(CandyCrush1D("aaabbbacd"));
    }

    public static String CandyCrush1D(String s){

        Stack<Character> letters = new Stack<Character>();
        Stack<Integer> occurance = new Stack<Integer>();

        int i =0;

        while( i<s.length()){
            char c = s.charAt(i);
            if(letters.isEmpty() || c != letters.peek()){
                if(!letters.isEmpty() && occurance.peek()>=3){
                    letters.pop();
                    occurance.pop();
                }else{
                    letters.push(s.charAt(i));
                    occurance.push(1);
                    i++;
                }

            }else{
                int count = occurance.pop();
                count++;
                occurance.push(count);
                i++;
            }

        }

        if(occurance.peek()>=3){
            letters.pop();
            occurance.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!letters.isEmpty()){
            char c = letters.pop();
            int count = occurance.pop();
            while(count>0){
                sb.append(c);
                count--;
            }
        }

        return sb.reverse().toString();

    }
}
