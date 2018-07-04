package maze;

import java.util.Arrays;

public class Maze {

    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int EXIT = 3;
    private static final int PATH = 4;
    private int [][] maze;
    private boolean [][] visited;
    private Coordinate start;
    private Coordinate end;

    public Maze(int [][] maze){
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];

        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze.length; j++){
                if(maze[i][j] == START){
                    start = new Coordinate(i, j);
                } else if (maze[i][j] == EXIT) {
                    end = new Coordinate(i, j);
                }
            }
        }
    }

    public Coordinate getEntry(){
        return this.start;
    }

    public Coordinate getExit(){
        return this.end;
    }

    public int getHeigth(){
        return maze.length;
    }

    public int getWidth(){
        return maze[0].length;
    }

    public boolean isExit(int x, int y){
        return x == end.getX() && y == end.getY();
    }

    public boolean isStart(int x, int y){
        return x == start.getX() && y == start.getY();
    }

    public boolean isWall(int row, int col){
        return this.maze[row][col] == WALL;
    }

    public boolean isValidLocation(int row, int col){
        if(row >= 0 && row<getHeigth() && col >= 0 && col<getWidth()){
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
