package LeetCodes;

public class LC121BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {

            int T_i10 = 0, T_i11 = Integer.MIN_VALUE;

            for(int price : prices){
                T_i10 = Math.max(T_i10, price + T_i11);
                T_i11 = Math.max(-price, T_i11);
            }

            return T_i10;
        }
    }
}
