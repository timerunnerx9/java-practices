package GeneralProblems;

import java.util.*;

public class sortFilesBasedOnStringsThenByNumbers {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<String>();
        testList.add("league.exe.part1");
        testList.add("league.exe.part5");
        testList.add("league.exe.part2");
        testList.add("league.exe.part6");
        testList.add("league.exe.part9");
        testList.add("league.exe.part21");
        Collections.sort(testList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1)-extractInt(o2);
            }

            int extractInt(String s){
                String num = s.replaceAll("\\D","");
                return num.isEmpty()? 0:Integer.parseInt(num);
            }
        });

        testList.forEach((String s)-> System.out.println(s));

    }

}
