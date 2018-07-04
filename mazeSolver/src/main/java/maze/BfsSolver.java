package maze;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BfsSolver {

    private static final int [][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

    public static List<Coordinate> solver(Maze maze){

        LinkedList<Coordinate> nextToVisited = new LinkedList<Coordinate>();
        nextToVisited.add(maze.getEntry());

        while(!nextToVisited.isEmpty()){
            Coordinate cur = nextToVisited.remove();

            if(maze.isWall(cur.getX(), cur.getY()) || maze.isExplored(cur.getX(), cur.getY())){
                maze.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if(maze.isExit(cur.getX(), cur.getY())){
                return backTrackingPath(cur);
            }

            for(int[] dir : DIRECTIONS){
                if(maze.isValidLocation(cur.getX()+dir[0], cur.getY()+dir[1])){
                    Coordinate coord = new Coordinate(cur.getX()+dir[0], cur.getY()+dir[1], cur);
                    nextToVisited.add(coord);
                    maze.setVisited(cur.getX(), cur.getY(), true);
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static List<Coordinate> solver2(Maze maze) {
        LinkedList<Coordinate> nextToVisit = new LinkedList<Coordinate>();
        Coordinate start = maze.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            Coordinate cur = nextToVisit.remove();

            if (!maze.isValidLocation(cur.getX(), cur.getY()) || maze.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            if (maze.isWall(cur.getX(), cur.getY())) {
                maze.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if (maze.isExit(cur.getX(), cur.getY())) {
                return backTrackingPath(cur);
            }

            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                maze.setVisited(cur.getX(), cur.getY(), true);
            }
        }
        return Collections.emptyList();
    }

    private static List<Coordinate> backTrackingPath(Coordinate cur) {
        List<Coordinate> path = new LinkedList<Coordinate>();
        path.add(cur);
        while(cur.getParent() != null){
            path.add(cur.getParent());
            cur = cur.getParent();
        }
        return path;
    }

}
