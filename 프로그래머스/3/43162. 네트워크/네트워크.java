class Solution {
    public int[][] arr;
    public int N;
    
    public int solution(int n, int[][] computers) {
        arr = computers;
        N = n;
        
        int cnt = 0;
        
        for(int r = 0 ; r < n ; r++){
            for(int c = r ; c < n ; c++){
                if(r == c && arr[r][c] == 1) {
                    arr[r][c] = 0;
                    cnt++;
                }
                else if(arr[r][c] == 1) {
                    arr[r][c] = 0;
                    arr[c][r] = 0;
                    dfs(c);
                }
            }
        }
        
        return cnt;
    }
    
    public void dfs(int index){
        for(int i = 0 ; i < N ; i++) {
            if(i == index){
                arr[index][i] = 0;
            }
            else if(arr[index][i] == 1){
                arr[index][i] = 0;
                dfs(i);
            }
        }
    }
}