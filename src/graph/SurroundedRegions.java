package com.practice.graph;

/**
 * Created by pankajtripathi on 11/12/16.
 */

/*
*
* Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
* A region is captured by flipping all 'O's into 'X's in that surrounded region.
*
* To count the number of islands in solve function replace the with '1' and add counter
*
*        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    merge(grid, i, j);
                }
            }
         }
         return count;

*
*
* The other variation is walls and gates problem.
* You are given a m x n 2D grid initialized with these three possible values.
* -1  A wall or an obstacle. 0  A gate. INF - Infinity means an empty room.
* We use the value 231 - 1 = 2147483647 to represent INF
*
* Fill each empty room with the distance to its nearest gate.
* If it is impossible to reach a gate, it should be filled with INF.
*
* i/p
*
* INF  -1  0  INF
* INF INF INF  -1
* INF  -1 INF  -1
*  0  -1 INF INF
*
*  o/p
*  3  -1   0   1
*  2   2   1  -1
*  1  -1   2  -1
*  0  -1   3   4
*
*       for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(rooms[i][j] == 0)
                    fill(rooms, i, j, 0);
            }
        }

        In merge function

        if(i < 0 || j < 0 || i >= row || j >= col || rooms[i][j] < distance) return;
        rooms[i][j] = distance;

        fill(rooms, i-1, j, distance+1);
        fill(rooms, i+1, j, distance+1);
        fill(rooms, i, j-1, distance+1);
        fill(rooms, i, j+1, distance+1);

* */

public class SurroundedRegions {
    public static void main(String[] args) {
        char board[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}
        };
        char[][] out = new SurroundedRegions().solve(board);

        for(int i=0; i<out.length; i++){
            for (int j = 0; j < out[0].length; j++) {
                System.out.print(out[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return new char[][]{{}};

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
                    if(board[i][j] == '0')
                        merge(board, i, j);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '0')
                    board[i][j] = 'X';
                else if(board[i][j] == 'V')
                    board[i][j] = '0';
            }
        }
        return board;
    }

    public void merge(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;

        if(i<0 || i>=row || j<0 || j>=col || board[i][j]!='0')
            return;

        board[i][j] = 'V';

        if(i>1)
            merge(board, i-1, j);
        if(i+1 < row)
            merge(board, i+1, j);
        if(j>1)
            merge(board, i, j-1);
        if(j+1 < col)
            merge(board, i, j+1);
    }
}
