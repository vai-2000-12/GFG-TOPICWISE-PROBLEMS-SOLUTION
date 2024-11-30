import java.util.*;
class Solution {
    public boolean isSafe(int row , int col , int[][]board){
     
     for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // Check for queens on the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // Check for queens on the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
     
        
    }
    public void solve(int row , int[][]board , ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        //Boundary Condition:-
        int size = board[0].length;
        if(row == size){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int col = 0 ; col < size ; col++){
           if(isSafe(row , col , board)){
               board[row][col] = 1;
               curr.add(col+1);
               //Recursive Call
               solve(row+1 , board , curr , res);
               // Backtrack
               board[row][col] = 0;
               curr.remove(curr.size()-1);
           }    
        }
        
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       ArrayList<Integer> curr = new ArrayList<>();
       int[][]board = new int[n][n];
       solve(0 , board, curr, res);
       return res;
    }
}