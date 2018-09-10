package excersices;

import java.util.*;

public class NClosePoints {
    static List<Point> list;

    public static void main(String[] args)
    {
        list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no of points : ");
        int size = in.nextInt();int i;
        for (i = 0; i < size; i++) {
            Point tmp = new Point(in.nextInt(), in.nextInt());
            list.add(tmp);
        }
        System.out.print("Enter N of N closest points needed : ");
        int n = in.nextInt();
        Collections.sort(list, new Comparator<Point>(){
            @Override
            public int compare(Point p1,Point p2){
                return (int) ((Math.pow(p1.x, 2)+Math.pow(p1.y, 2))-(Math.pow(p2.x, 2)+Math.pow(p2.y, 2)));
            }
        });
        i=0;
        for (Point tmp : list) {
            if(i<n)
                System.out.println("Point "+(i+1)+" : "+tmp);
            else
                break;
            i++;
        }
    }

    static class Point
    {
        int x, y;

        Point(int i, int j)
        {
            x = i;
            y = j;
        }

        @Override
        public String toString(){
            return "( "+x+" , "+y+" )";
        }
    }
}
