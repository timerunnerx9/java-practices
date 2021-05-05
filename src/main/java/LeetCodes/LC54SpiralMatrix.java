package LeetCodes;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int startRow = 0;
            int startColumn = 0;
            int endRow = matrix.length-1;
            int endColumn = matrix[0].length-1;

            int size = (endRow+1)*(endColumn+1);

            int dir = 0;

            while(result.size()<size){

                switch(dir){
                    //left to right
                    case 0:
                        for(int i = startColumn; i <= endColumn; i++){
                            result.add(matrix[startRow][i]);
                        }
                        startRow++;
                        break;
                    //up to down
                    case 1:
                        for(int i = startRow; i<= endRow; i++){
                            result.add(matrix[i][endColumn]);
                        }
                        endColumn--;
                        break;

                    // right to left
                    case 2:
                        for(int i = endColumn; i>=startColumn; i--){
                            result.add(matrix[endRow][i]);
                        }
                        endRow--;
                        break;

                    // bottom to up
                    case 3:
                        for(int i = endRow; i>=startRow; i--){
                            result.add(matrix[i][startColumn]);
                        }
                        startColumn++;
                        break;

                }

                dir = (dir+1)%4;
            }

            return result;

        }
    }
}
