
    class Solution {
        // public int util(int i,int j,String text1,String text2,int dp[][]){
        //     if(i < 0 || j < 0 )return 0;
        //     if(dp[i][j] !=-1) return dp[i][j];
        //     if(text1.charAt(i) == text2.charAt(j)) return dp[i][j] = 1+util(i-1,j-1,text1,text2,dp);
        //     else return dp[i][j] = Math.max(util(i-1,j,text1,text2,dp),util(i,j-1,text1,text2,dp));
        // }
        public int longestCommonSubsequence(String text1, String text2) {
            int dp[][] = new int[text1.length()][text2.length()];
            // for(int row[]:dp) Arrays.fill(row,0);
            for(int i =0;i<text1.length();i++){
                for(int j =0;j<text2.length();j++){
                    if(text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j]++ ;
                        if(i>0 && j>0)dp[i][j]+=dp[i-1][j-1];
                    }
                    else {
                        int max = 0;
                        if(i>0) max = Math.max(dp[i-1][j],max);
                        if(j>0) max = Math.max(dp[i][j-1],max);
                        dp[i][j] = max;
                    }
                }
            }

            return dp[text1.length()-1][text2.length()-1];

            // return util(text1.length()-1,text2.length()-1,text1,text2,dp);
        }
}
