package maze;

import java.util.List;

public class MazeDriver {

    public static void printPath(List<Coordinate> path){
        for(Coordinate c: path){
            System.out.println("x:" + String.valueOf(c.getX()) + ", y:"+ String.valueOf(c.getY()));
        }
    }

    public static void main(String[] args) {
        int[][] maze1 = {
                {1,1,2,1,1},
                {1,0,0,0,1},
                {0,0,1,0,1},
                {0,1,0,0,1},
                {3,1,1,1,1}
        };

        Maze mazeo1 = new Maze(maze1);
        List<Coordinate> path = BfsSolver.solver(mazeo1); //  0,2 - 1,2 - 1,1 - 2,1 - 2,0 - 3,0 - 4,0
        printPath(path);
        mazeo1.reset();

        /*System.out.println("\n\n");
        List<maze.Coordinate> path1 = maze.BfsSolver.solver2(mazeo1); //  0,2 - 1,2 - 1,1 - 2,1 - 2,0 - 3,0 - 4,0
        printPath(path1);*/
    }

}
