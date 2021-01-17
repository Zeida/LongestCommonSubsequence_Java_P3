package LongestCommonSubsequence;

/**
 *
 * @author Zeida
 */
public class LCS_Memoization {
  
    public static int lcs(String str1, String str2, boolean lcs)
    {
        int m = str1.length();
        int n = str2.length();
 
        int[][] arr = new int[m + 1][n + 1];
 
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
        if(lcs == true){
            int i = 0, j = 0;
            StringBuffer sb = new StringBuffer();
            while (i < m && j < n) 
            {
                if (str1.charAt(i) == str2.charAt(j)) 
                {
                    sb.append(str1.charAt(i));
                    i++;
                    j++;
                }
                else if (arr[i + 1][j] >= arr[i][j + 1]) 
                    i++;
                else
                    j++;
            }
            System.out.println("The LCS is: " + sb.toString());
        }
        return arr[0][0];
        
    }
    
}
