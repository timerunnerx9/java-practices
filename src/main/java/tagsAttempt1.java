import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tagsAttempt1 {

        public static void main(String[] args) throws IOException {

            String fileName;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String newLine;
            String fileString;
            StringBuilder sb = new StringBuilder();

            while ((newLine=fileReader.readLine())!=null) {
                sb.append(newLine);
            }
            fileString = sb.toString();
            reader.close();
            fileReader.close();


            Pattern pattern = Pattern.compile("<.+?>");
            Matcher matcher = pattern.matcher(fileString);
            List<List<String>> tagList = new ArrayList<>();

            while (matcher.find()) {
                List<String> tempList = new ArrayList<>();
                tempList.add(matcher.group());
                tempList.add(String.valueOf(matcher.start()));
                tempList.add(String.valueOf(matcher.end()));
                tagList.add(tempList);
            }


            Stack<String> tagStack = new Stack<>();
            List<String> printList = new ArrayList<>();


            for (int i = 0; i < tagList.size(); i++) {
                String tag = tagList.get(i).get(0);


                for (String s : args) {
                    if (tag.startsWith("<"+s)) {
                        Integer startIndex = Integer.valueOf(tagList.get(i).get(1));
                        tagStack.push(tagList.get(i).get(0));

                        innerWhileBlock:
                        while (!tagStack.empty()) {
                            for (int j = i + 1; j < tagList.size(); j++) {
                                if (!tagList.get(j).get(0).startsWith("</")) {
                                    tagStack.push(tagList.get(j).get(0));
                                } else if (tagList.get(j).get(0).startsWith("</")) {
                                    if (tagStack.peek().contains(tagList.get(j).get(0).replace("/", "")
                                            .replace("<", "").replace(">", ""))) {
                                        tagStack.pop();
                                        if (tagStack.empty()) {
                                            Integer endIndex = Integer.valueOf(tagList.get(j).get(2));
                                            String outputString = fileString.substring(startIndex, endIndex);
                                            printList.add(outputString);
                                            break innerWhileBlock;

                                        }
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







