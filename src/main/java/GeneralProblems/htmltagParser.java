package GeneralProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class htmltagParser {
    public static void main(String[] args) {
        String testString = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Leela Turanga" +
                "</span></b></span><span>Super</span><span>girl</span>";
        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(testString);
        List<List<String>> tagList = new ArrayList<>();

        while(matcher.find()){
            List<String> tempList = new ArrayList<>();
            tempList.add(matcher.group());
            tempList.add(String.valueOf(matcher.start()));
            tempList.add(String.valueOf(matcher.end()));
            tagList.add(tempList);
        }


        Stack<String> tagStack = new Stack<>();
        List<String> printList = new ArrayList<>();

        String inputTag = "b";
        for(int i = 0; i<tagList.size();i++){
            String tag = tagList.get(i).get(0);

            if(tag.contains(inputTag) && !tag.contains("/")){
                Integer startIndex = Integer.valueOf(tagList.get(i).get(1));
                tagStack.push(tagList.get(i).get(0));

                innerWhileBlock:
                while(!tagStack.empty()){
                    for(int j = i+1; j<tagList.size();j++){
                        if(!tagList.get(j).get(0).contains("/")){
                            tagStack.push(tagList.get(j).get(0));
                        }else if(tagList.get(j).get(0).contains("/")){
                            if(tagStack.peek().contains(tagList.get(j).get(0).replace("/","")
                                    .replace("<","").replace(">",""))){
                                tagStack.pop();
                                if(tagStack.empty()){
                                    Integer endIndex = Integer.valueOf(tagList.get(j).get(2));
                                    String outputString = testString.substring(startIndex,endIndex);
                                    printList.add(outputString);
                                    break innerWhileBlock;


                                }
                            }
                        }
                    }
                }
            }

        }
        printList.forEach(System.out::println);

    }
}
