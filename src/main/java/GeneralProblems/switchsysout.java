package GeneralProblems;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class switchsysout {
    public static void main(String[] args) throws Exception
    {
        //Save the current PrintStream in a special variable
        PrintStream consoleStream = System.out;

        //Create a dynamic array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Create an adapter for the PrintStream class
        PrintStream stream = new PrintStream(outputStream);
        //Set it as the current System.out
        System.setOut(stream);

        //Call a function that knows nothing about our changes
        printSomething();

        //Convert the data written to our ByteArray into a string
        String result = outputStream.toString();

        //Put everything back to the way it was
        System.setOut(consoleStream);

        //Reverse the string
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.reverse();
        String reverseString = stringBuilder.toString();

        //Output it to the console
        System.out.println(reverseString);
    }

    public static void printSomething()
    {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}

