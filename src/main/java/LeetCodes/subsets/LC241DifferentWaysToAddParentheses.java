package LeetCodes.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC241DifferentWaysToAddParentheses {

    class Solution {
        Map<String, List<Integer>> resultMap = new HashMap<>(); // use hashMap to store replicate past result to reduce computation time

        public List<Integer> diffWaysToCompute(String expression) {

            if(resultMap.containsKey(expression)){   // if we have computed for the expression before, just return
                return resultMap.get(expression);
            }

            List<Integer> result = new ArrayList<>();

            if(!expression.contains("+") && !expression.contains("-")  && !expression.contains("*") ){  // if the current expression
                result.add(Integer.parseInt(expression));  // doesn't contain any operator, then it's a pure number string
            }else{

                for(int i = 0; i < expression.length(); i++){ // iterate through the expression to find the operator

                    char currChar = expression.charAt(i);

                    if(!Character.isDigit(currChar)){ //if we found an operator, we divide the expression into left and right,
                        // and call the function recursively till we have a pure number string,
                        // then parse it and add to result
                        List<Integer> left = diffWaysToCompute(expression.substring(0, i));   // left part will have a list of different results we can have from the left side of the operator

                        List<Integer> right = diffWaysToCompute(expression.substring(i+1));// right part will have a list of different results we can have from the right side of the operator


                        for(int j : left){  // iterate throught both left and right result lists to find all combination, add them to the result
                            for(int k: right){
                                switch(currChar){

                                    case '+':
                                        result.add(j+k);
                                        break;
                                    case '-':
                                        result.add(j-k);
                                        break;
                                    case '*':
                                        result.add(j*k);
                                        break;

                                }

                            }
                        }
                    }


                }
            }

            resultMap.put(expression, result); // store result and expression in the hashmap so we can use when we see the expression again
            return result;

        }
    }
}
