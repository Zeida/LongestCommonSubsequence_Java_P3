package LongestCommonSubsequence;

/**
 *
 * @author Zeida
 */
public class LCS_Tabulation {

 
    public static int LCSLength(String X, String Y, int m, int n, int[][] T){
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        return T[m][n];
    }
    
       public static String LCS(String X, String Y, int m, int n, int[][] T){
        if (m == 0 || n == 0) {
            return new String();
        }
        
        if (X.charAt(m - 1) == Y.charAt(n - 1)){
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }
        
        if (T[m - 1][n] > T[m][n - 1]) {
            return LCS(X, Y, m - 1, n, T);
        }
        else {
            return LCS(X, Y, m, n - 1, T);
        }
    }
}
