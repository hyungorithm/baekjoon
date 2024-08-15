class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        for(int r = 0 ; r < len ; r++){
            for(int c = 0 ; c <= r ; c++){
                if(r == 0){
                    dp[r][c] = triangle[r][c];
                }
                else if(c == 0){
                    dp[r][c] = dp[r-1][c] + triangle[r][c];
                }
                else if(r == c){
                    dp[r][c] = dp[r-1][c-1] + triangle[r][c];
                }
                else{
                    dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + triangle[r][c];
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0 ; i < len ; i++){
            if(dp[len-1][i] > answer)
                answer = dp[len-1][i];
        }
        
        return answer;
    }
}