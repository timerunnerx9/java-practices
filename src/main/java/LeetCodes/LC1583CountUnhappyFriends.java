package LeetCodes;

public class LC1583CountUnhappyFriends {
    class Solution{
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            int lenpairs = pairs.length;
            int[][] degree = new int[n][n];
            int res = 0;
            for (int i = 0; i < lenpairs; i++) {
                int firstfriend = pairs[i][0];
                int lastfriend = pairs[i][1];
                judge(preferences, degree, firstfriend, lastfriend);
                judge(preferences, degree, lastfriend, firstfriend);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (degree[i][j] == 1 && degree[j][i] == 1){
                        res++;
                        break;
                    }
                }
            }
            return res;
        }

        private void judge(int[][] preferences, int[][] degree, int firstfriend, int lastfriend) {
            for (int i = 0; preferences[firstfriend][i] != lastfriend; i++) {
                degree[firstfriend][preferences[firstfriend][i]] = 1;
            }
        }
    }
}
