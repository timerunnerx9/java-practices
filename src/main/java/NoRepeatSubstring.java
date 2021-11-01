import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String s) {

        if(s==null || s.length()==0) return 0;

        int left = 0, maxLength = 0;
        Map<Character,Integer> seenMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char currentChar = s.charAt(right);
            if(seenMap.containsKey(currentChar)){

                left = Math.max(left, seenMap.get(currentChar) + 1);

            }
            seenMap.put(currentChar,right);
            maxLength = Math.max(maxLength, right - left + 1);


        }

        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbaacba"));
//        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
//        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}