package excersices;

import com.sun.org.apache.xpath.internal.Arg;

import java.util.LinkedList;
import java.util.List;

public class google {

    /**
     On our special chessboard, two bishops attack each other if they share the same diagonal.
     This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.

     You are given N bishops, represented as (row, column) tuples on a M by M chessboard.
     Write a function to count the number of pairs of bishops that attack each other.
     The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).

     For example, given M = 5 and the list of bishops:
     (0, 0)
     (1, 2)
     (2, 2)
     (4, 0)

     The board would look like this:
     [b 0 0 0 0]
     [0 0 b 0 0]
     [0 0 b 0 0]
     [0 0 0 0 0]
     [b 0 0 0 0]

     You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.
     */
    public static int bishopsUnderAttack(List<int []> bishops, int m){
        int [][] board = new int [m][m];
        int count=0;

        for (int [] point : bishops) {
            board[point[0]][point[1]] = 1;
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<m; j++){
                if (board[i][j] == 1) {
                    if (isInAttack(board, i, j, m)) {
                        count++;
                    }
                }
            }
        }

        printBoard(board, m);
        return count;
    }

    private static boolean isInAttack(int [][] board, int x, int y, int m) {
        int[][] directions = {{1,1}, {-1,-1}, {-1,1}, {1,-1} };
        //System.out.println(String.format("**** x:%s, y:%s ****", x, y));
        int xp = x, yp =y;
        for (int[] dir : directions) {
           x = x+dir[0]; y = y+dir[1];
           while (x < m && y < m && x >= 0 && y >= 0) {
               if (board[x][y] >= 1 ) {
                   board[x][y] = 2;
                   return true;
               }
               x = x+dir[0]; y = y+dir[1];
           }
           x = xp; y = yp;
        }
        return false;
    }

    public static void printBoard(int [][] board, int m) {
        System.out.println();
        for (int i=0; i<m; i++){
            for (int j=0; j<m; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        List<int []> bishops = new LinkedList<>();
        bishops.add(new int[]{0,0});
        //bishops.add(new int[]{0,4});
        bishops.add(new int[]{1,3});
        bishops.add(new int[]{2,3});
        bishops.add(new int[]{1,2});
        bishops.add(new int[]{2,2});
        bishops.add(new int[]{4,0});
        System.out.println(bishopsUnderAttack(bishops, 5));
    }


}
