package GeneralProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class CodeGymArmStrongNumbers {

        private static long[][] pows;

        // pre-generating all the power result that we need to use later
        private static void genPows(long N) {
            pows = new long[10][(int) N+1];
            for (int i = 0; i < pows.length; i++) {
                long p = 1;
                for (int j = 0; j < pows[i].length; j++) {
                    pows[i][j] = p;
                    p *= i;
                }
            }
        }

        public static long[] getNumbers(long N) {
            try {
                //excluding 0
                if(N <= 0)return new long[0];

                //find out the length of the input N
                int inputLength = String.valueOf(N).length();

                //generate all the powers for 0-9
                genPows(inputLength);

                //use this to hold the results
                long[] result;

                //use this to store the results
                ArrayList<Long> returnList = new ArrayList<>();

                //just the sum
                long sum = 0;

                outer:
                for (int i = 1; i < N; i++) {
                    //find out the length of the current number
                    String numberString = String.valueOf(i);
                    for(int j=0; j<numberString.length();j++){
                        //get the numeric value for the current number, current digit
                        int digit = Character.getNumericValue(numberString.charAt(j));
                        //add the power result to the sum
                        sum += pows[digit][numberString.length()];
                        //if the result is bigger than N, break it, continue
                        if (sum >= N) {
                            sum = 0;
                            continue outer;
                        }
                    }
                    //check if the sum match itself
                    if (sum == i) {
                        returnList.add(sum);
                        sum = 0;
                    } else {
                        sum = 0;
                    }
                }

                // turning the result list to array
                result = returnList.stream().mapToLong(l -> l).toArray();
                return result;

            }catch (Exception e){
                return null;
            }
        }

        public static void main(String[] args) {
        long a = System.currentTimeMillis();
        getNumbers(1000);
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

//        a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(1000000)));
//        b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);

//        a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(10000000)));
//        b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);


        }

    }


