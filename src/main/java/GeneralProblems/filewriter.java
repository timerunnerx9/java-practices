package GeneralProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;

public class filewriter {
    public static void main(String[] args) {

        int[] someArray = {1,0,2,3,0,4,5,0};
        duplicateZeros(someArray);



}
    public static void duplicateZeros(int[] arr) {
        int[] newArr = arr.clone();
        int j = 0;
        for(int i = 0; i<newArr.length; i++){
            if(j<arr.length){

                arr[j] = newArr[i];
                if(newArr[i]==0){
                    j++;
                    if(j<arr.length) {
                        arr[j] = 0;
                    }else {
                        break;
                    }
                }
                j++;
            }else{
                break;
            }

        }

        for(int i: arr){
            System.out.print(i+" ");
        }
    }


}
