package GeneralProblems;

import java.util.Stack;

public class BBCandyCrush1DDave2 {

    public static void main(String[] args) {

        System.out.println(CandyCrush1D("aaabbbc"));
        System.out.println(CandyCrush1D("aabbbacd"));
        System.out.println(CandyCrush1D("aabbccddeeedcba"));
        System.out.println(CandyCrush1D("aaabbbacd"));
    }

    public static String CandyCrush1D(String s){
        Stack<Character> letters = new Stack<>();
        Stack<Integer> occurance = new Stack<>();

        int i = 0;

        while(i<s.length()){

            char c = s.charAt(i);

            // try to add the character if the letter stack is empty or when the character isn't equal to the
            // top character
            if(letters.isEmpty() || c!=letters.peek()){

                // check if the current stack has anything to crush
                if(!letters.isEmpty() && occurance.peek()>=3){
                    letters.pop();
                    occurance.pop();
                }else{
                    letters.push(c);
                    occurance.push(1);
                    i++;
                }
            }else{
                occurance.push(occurance.pop()+1);
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
