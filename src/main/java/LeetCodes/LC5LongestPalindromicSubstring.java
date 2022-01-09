package LeetCodes;

public class LC5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        if(s.length() == 1) return s;

        String s1 = "", s2 = "";
        for(int i = 0; i < s.length(); i++){

            s1 = extendFromMid(s, i, i);
            s2 = extendFromMid(s, i, i+1);


        }

        return s1.length() > s2.length()? s1 : s2;

    }

    public static String extendFromMid(String s, int left, int right){

        int maxLength = 0;

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                maxLength = Math.max(maxLength, right - left +1);
                left--;
                right++;
            }else{

                ;
                break;

            }
        }

        return s.substring(left + 1, left  + 1 + maxLength );


    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacd"));
    }
}

