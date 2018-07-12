package excersices;

public class HtreeConstruction {

    static int numNodes = 0;

    public static void drawHTree(float x, float y, float length, int depth) {
        if (depth == 0)
            return;

        drawHNode(x, y, length);
        depth -= 1;
        length /= Math.sqrt(length);
        float lengthdiv2 = length/2;

        drawHTree(x+lengthdiv2, y+lengthdiv2, length, depth);
        drawHTree(x+lengthdiv2, y-lengthdiv2, length, depth);
        drawHTree(x-lengthdiv2, y+lengthdiv2, length, depth);
        drawHTree(x-lengthdiv2, y-lengthdiv2, length, depth);
    }

    public static void drawHNode(float x, float y, float length){
        float lengthdiv2 = length/2;
        drawLine(x+lengthdiv2, y, x-lengthdiv2, y); // horizontal
        drawLine(x-lengthdiv2, y+lengthdiv2, x-lengthdiv2, y-lengthdiv2); // left Vertical
        drawLine(x+lengthdiv2, y-lengthdiv2, x+lengthdiv2, y+lengthdiv2); // rigth Vertical
    }

    public static void drawLine(float x, float y, float x2, float y2) {
        String line = String.format("Node: %s, %s, %s, %s, %s", numNodes, x, y, x2, y2);
        System.out.println(line);
        System.out.println( "" );
        numNodes++;
    }

    static public void main( String args[] ) {
        System.out.println( "Practice makes Perfect!" );

        drawHTree(4,4,2,2);
    }

}
