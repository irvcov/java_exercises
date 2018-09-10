package excersices;

import org.junit.Assert;

public class numberOfIslands {

    public static int numOfIslands(int[][] mx){
        int numberIsland = 0;
        for(int i=0; i<mx.length; i++){
            for(int j=0; j<mx[0].length; j++){
                if(mx[i][j] == 1){
                    numberIsland++;
                    markIsland(mx, i, j, mx[0].length, mx.length);
                }
            }
        }

        return numberIsland;
    }

    private static void markIsland(int[][] mx, int i, int j, int l, int r){

        if( j < l && i < r && j >= 0 && i >= 0  && mx[i][j] == 1){
            mx[i][j] = Integer.MAX_VALUE;
        } else {
            return;
        }

        //System.out.println("x:"+String.valueOf(i)+", y:"+String.valueOf(j));
        markIsland(mx, i+1, j, l, r);
        markIsland(mx, i-1, j, l, r);
        markIsland(mx, i, j+1, l, r);
        markIsland(mx, i, j-1, l, r);
    }


    public static void main(String[] args) {

        int[][] mx = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        Assert.assertEquals(0, numOfIslands(mx));

        int[][] mx1 = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,0,1,0},
                {0,1,1,1,0},
                {0,1,0,0,1},
                {1,0,0,1,0}
        };
        Assert.assertEquals(4, numOfIslands(mx1));

        int[][] mx2 = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,0,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {1,0,0,1,0}
        };
        Assert.assertEquals(3, numOfIslands(mx2));

        int[][] mx3 = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,1},
                {1,1,0,1,1}
        };
        Assert.assertEquals(2, numOfIslands(mx3));

        int[][] mx4 = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,1,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        Assert.assertEquals(1, numOfIslands(mx4));

    }
}