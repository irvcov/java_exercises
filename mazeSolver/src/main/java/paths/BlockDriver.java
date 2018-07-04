package paths;

import maze.BfsSolver;
import maze.Coordinate;
import maze.Maze;

import java.util.List;

public class BlockDriver {

    public static void printPath(List<Coordinate> path){
        for(Coordinate c: path){
            System.out.println("x:" + String.valueOf(c.getX()) + ", y:"+ String.valueOf(c.getY()));
        }
    }

    public static void main(String[] args) {
        int[][] map1 = {
                {0,0,1,1,1},
                {0,0,0,0,0},
                {0,1,1,0,1},
                {0,1,1,0,1},
                {0,0,0,0,2}
        };

        Block block1 = new Block(0,0, map1);
        List<Coordinate> path = BfsPaths.shortedPath(block1); //  0,2 - 1,2 - 1,1 - 2,1 - 2,0 - 3,0 - 4,0
        printPath(path);
        block1.reset();
        System.out.println("\n\n");

        List<List<Coordinate>> paths = BfsPaths.allPaths(block1); //  0,2 - 1,2 - 1,1 - 2,1 - 2,0 - 3,0 - 4,0
        for(List<Coordinate> p : paths){
            printPath(p);
            System.out.println("\n\n");
        }
        block1.reset();

        /*System.out.println("\n\n");
        List<maze.Coordinate> path1 = maze.BfsSolver.solver2(mazeo1); //  0,2 - 1,2 - 1,1 - 2,1 - 2,0 - 3,0 - 4,0
        printPath(path1);*/
    }

}
