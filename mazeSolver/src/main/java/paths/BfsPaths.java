package paths;

import maze.Coordinate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BfsPaths {

    private static final int [][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

    public static List<Coordinate> shortedPath(Block block){
        //List<Coordinate> path = new LinkedList<Coordinate>();
        LinkedList<Coordinate> toVisit = new LinkedList<Coordinate>();
        toVisit.add(block.getEntry());

        while(!toVisit.isEmpty()){
            Coordinate cur = toVisit.remove();
            //System.out.println(cur.getX() + ", " + cur.getY());
            if(block.isBlock(cur.getX(), cur.getY()) || block.isExplored(cur.getX(), cur.getY())){
                block.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if(block.isTarget(cur.getX(), cur.getY())){
                return backTrackingPath(cur);
            }

            for(int[] dir : DIRECTIONS){
                if(block.isValidLocation(cur.getX() + dir[0], cur.getY() + dir[1])){
                    Coordinate cord = new Coordinate(cur.getX() + dir[0],cur.getY() + dir[1], cur);
                    toVisit.add(cord);
                    block.setVisited(cur.getX(), cur.getY(), true);
                }
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

    public static List<List<Coordinate>> allPaths(Block block) {
        List<List<Coordinate>> paths = new LinkedList<List<Coordinate>>();
        LinkedList<Coordinate> toVisit = new LinkedList<Coordinate>();
        toVisit.add(block.getEntry());

        while (!toVisit.isEmpty()) {
            Coordinate cur = toVisit.remove();
            //System.out.println(cur.getX() + ", " + cur.getY());
            if (block.isBlock(cur.getX(), cur.getY()) || block.isExplored(cur.getX(), cur.getY())) {
                block.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if (block.isTarget(cur.getX(), cur.getY())) {
                paths.add( backTrackingPathSetToVisit(cur, block) );
                toVisit = new LinkedList<Coordinate>();
                toVisit.add(block.getEntry());
            }

            for (int[] dir : DIRECTIONS) {
                if (block.isValidLocation(cur.getX() + dir[0], cur.getY() + dir[1])) {
                    Coordinate cord = new Coordinate(cur.getX() + dir[0], cur.getY() + dir[1], cur);
                    toVisit.add(cord);
                    block.setVisited(cur.getX(), cur.getY(), true);
                }
            }

        }

        return paths;
    }

    private static List<Coordinate> backTrackingPathSetToVisit(Coordinate cur, Block block) {
        List<Coordinate> path = new LinkedList<Coordinate>();
        path.add(cur);
        while(cur.getParent() != null){
            path.add(cur.getParent());
            cur = cur.getParent();
            block.setVisited(cur.getX(), cur.getY(), true);
        }
        return path;
    }
}
