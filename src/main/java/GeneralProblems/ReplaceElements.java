package GeneralProblems;

public class ReplaceElements {
    public static void main(String[] args) {
        replaceElements(new int[]{17,18,5,4,6,1});
    }


    public static int[] replaceElements(int[] A) {
        for (int i = A.length - 1, mx = -1; i >= 0; --i)
            mx = Math.max(A[i], A[i] = mx);
        return A;
    }
}
