package GeneralProblems;

import java.util.*;

public class FunWithAnagram {

    public static void main(String[] args) {


        List<String> list = new ArrayList<String>(Arrays.asList(
                "code",
                "aaagmnrs",
                "anagrams",
                "doce",
                "lapd"));

        funWithAnagram(list);
        System.out.println(funWithAnagram(list).toString());
    }




    public static List<String> funWithAnagram(List<String> list){

        int slow = 0;
        int fast = 1;

        Set<Integer> indexToRemove = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(String s: list){
            result.add(s);
        }


        while(slow<result.size()){
            while(fast<result.size()){

                if(result.get(slow).length()!=result.get(fast).length()){
                    fast++;
                    continue;
                }

                else{
                    int bitMaskA = 0;
                    int bitMaskB = 0;

                    char[] aChars = result.get(slow).toCharArray();
                    char[] bChars = result.get(fast).toCharArray();

                    for(int i = 0; i<aChars.length;i++){
                        bitMaskA |= 1<< (aChars[i]-'a');
                        bitMaskB |= 1<< (bChars[i]-'a');
                    }

                    int bitMaskResult = bitMaskA - bitMaskB;

                    if(bitMaskResult==0){
                        indexToRemove.add(fast);
                        fast++;
                    }else{
                        fast++;
                    }
                }


            }
            slow++;
            fast = slow+1;
        }


        for(int i : indexToRemove){
            result.remove(list.get(i));
        }

        Collections.sort(result);

        return result;
    }
}
