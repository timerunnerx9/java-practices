import java.io.File;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) {


        File file1 = new File("C:\\Users\\davec\\test1.txt");
//        try {
//            file1.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(file1.getAbsolutePath());
    }


}
