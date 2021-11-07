package LeetCodes.fastSlowPointers;

import java.util.HashMap;
import java.util.Map;

public class LC202HappyNumber {

        public static boolean isHappy(int n) {

            int slow = n, fast = n;

            do{
                slow = getSquaredSum(slow);
                fast = getSquaredSum(getSquaredSum(fast));

            }while(slow != fast);
            return slow == 1;
        }

        public static int getSquaredSum(int n){

            int sum = 0, digit;
            while(n > 0){
                digit = n%10;
                sum += digit * digit;
                n = n/10;
            }

            return sum;


        }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    }

