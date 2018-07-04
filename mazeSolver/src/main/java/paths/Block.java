package paths;

import maze.Coordinate;

import java.util.Arrays;

public class Block {

    private static int STREET = 0;
    private static int BLOCK = 1;
    private static int TARGET = 2;
    private int [][] map;
    private boolean [][] visited;
    private Coordinate start;

    public Block (int x, int y, int[][] map){
        start = new Coordinate(x,y);
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
    }

    public Coordinate getEntry(){
        return this.start;
    }

    public int getHeigth(){
        return map.length;
    }

    public int getWidth(){
        return map[0].length;
    }

    public boolean isStreet(int x, int y){
        return map[x][y] == STREET;
    }

    public boolean isBlock(int x, int y){
        return map[x][y] == BLOCK;
    }

    public boolean isTarget(int x, int y){
        return map[x][y] == TARGET;
    }

    public boolean isValidLocation(int x, int y){
        if(x>=0 && x<getHeigth() && y>=0 && y<getWidth()){
            return true;
        }
        return false;
    }

    public boolean isExplored(int row, int col){
        return visited[row][col];
    }

    public void setVisited(int row, int col, boolean toset){
        visited[row][col] = toset;
    }

    public void reset() {
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);
    }

}
