package Leetcode999;

public class Solution {
    public static void main(String[] args) {

    }
    public int numRookCaptures(char[][] board){
        int ans = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'R'){
                    int r = i - 1;
                    while(r >= 0) {
                        if(board[r][j] == 'B'){
                            break;
                        }
                        if(board[r][j] == 'p'){
                            ans++;
                            break;
                        }
                        r--;
                    }

                    r = i + 1;
                    while(r < 8) {
                        if(board[r][j] == 'B'){
                            break;
                        }
                        if(board[r][j] == 'p'){
                            ans++;
                            break;
                        }
                        r++;
                    }
                    int c = j - 1;
                    while(c >= 0){
                        if(board[i][c] == 'B'){
                            break;
                        }
                        if(board[i][c] == 'p'){
                            ans++;
                            break;
                        }
                        c--;
                    }
                    c = j + 1;
                    while(c < 8){
                        if(board[i][c] == 'B'){
                            break;
                        }
                        if(board[i][c] == 'p'){
                            ans++;
                            break;
                        }
                        c++;
                    }
                    return ans;
                }
            }
        }
        return ans;
    }

}
