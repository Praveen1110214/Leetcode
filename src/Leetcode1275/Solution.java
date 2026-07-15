package Leetcode1275;

public class Solution {
    public static void main(String[] args) {
        int[][] moves = {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};
        System.out.println(new Solution().tictactoe(moves));;
    }
    public String tictactoe(int[][] moves){
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '.';
            }
        }
        int parity = 0;
        for(int[] move : moves){
            int row = move[0];
            int col = move[1];
            if(parity % 2 == 0) {
                board[row][col] = 'A';
            } else {
                board[row][col] = 'B';
            }
            parity++;
        }
        for(int i = 0; i < 3; i++){
            if(board[i][0] != '.' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]){
                return String.valueOf(board[i][0]);
            }
        }
        for(int j = 0; j < 3; j++){
            if(board[0][j] != '.' &&
                    board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j]){
                return String.valueOf(board[0][j]);
            }
        }
        if(board[0][0] != '.' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]){
            return String.valueOf(board[0][0]);
        }
        if(board[0][2] != '.' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]){
            return String.valueOf(board[0][2]);
        }
        if(moves.length == 9){
            return "Draw";
        }
        return "Pending";
    }

    public String tictactoe2(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            // A = +1, B = -1
            int player = (i % 2 == 0) ? 1 : -1;
            rows[row] += player;
            cols[col] += player;
            if (row == col) {
                diagonal += player;
            }
            if (row + col == 2) {
                antiDiagonal += player;
            }
            if (Math.abs(rows[row]) == 3 ||
                    Math.abs(cols[col]) == 3 ||
                    Math.abs(diagonal) == 3 ||
                    Math.abs(antiDiagonal) == 3) {
                return player == 1 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
