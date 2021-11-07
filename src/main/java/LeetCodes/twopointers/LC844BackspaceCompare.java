package LeetCodes.twopointers;

public class LC844BackspaceCompare {

        public static boolean backspaceCompare(String s, String t) {

            int sIndex = s.length() - 1, tIndex = t.length() - 1;

            while( sIndex >= 0 || tIndex >= 0){


                int nextSIndex = getNext(s, sIndex);
                int nextTIndex = getNext(t, tIndex);

                if(nextSIndex < 0 && nextTIndex < 0){
                    return true;
                }

                if(nextSIndex < 0 || nextTIndex < 0){
                    return false;
                }

                if(s.charAt(nextSIndex) != t.charAt(nextTIndex)){
                    return false;
                }

                sIndex = nextSIndex - 1;
                tIndex = nextTIndex - 1;


            }

            return true; // at the end if two strings are the same, we will have -1 -1 indexes

        }

        public static int getNext(String str, int index){

            int backspaceCount = 0;

            while(index >= 0){

                if(str.charAt(index) == '#'){
                    backspaceCount++;
                }else if(backspaceCount > 0){
                    backspaceCount--;
                }else{
                    break;
                }

                index--;

            }

            return index;

        }


    public static void main(String[] args) {

        System.out.println(backspaceCompare("ab#d","ac#d"));
    }
    }

