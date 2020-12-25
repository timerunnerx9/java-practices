public class ReserveString {
    public void reverseString(char[] s) {
        int slow = 0;
        int fast = s.length;

        while(slow<fast){
            swap(s,slow,fast);
            slow++;
            fast--;
        }

    }

    public void swap(char[] s, int index1, int index2){
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }
}
