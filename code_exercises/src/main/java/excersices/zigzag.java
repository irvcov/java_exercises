package excersices;

public class zigzag {

    public static String convert(String s, int numRows) {

        if (s.length() < numRows || numRows == 1) {
            return s;
        } else if ( numRows == 2) {
            return togleString(s);
        }

        StringBuilder [] stbArr = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            stbArr[i] = new StringBuilder();
        }

        int countRow = 0; int idx = 0;
        boolean flagSkip = false; boolean flagReverse = false;

        while(true) {

            if (flagReverse)
                stbArr[numRows-1-countRow].append(s.charAt(idx));
            else
                stbArr[countRow].append(s.charAt(idx));

            //System.out.println(idx + ", " +countRow);

            if(flagSkip && countRow == numRows-2){
                countRow++;
            }

            countRow++;
            if (countRow == numRows) {

                flagSkip ^= true;
                flagReverse ^= true;

                if (flagSkip)
                    countRow = 1;
                else
                    countRow = 0;
            }

            idx++;
            if (idx >= s.length()){
                break;
            }
        }

        StringBuilder stb = new StringBuilder();

        for (StringBuilder b : stbArr) {
            stb.append(b);
        }

        return stb.toString();
    }

    public static String togleString(String s){
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();

        for (int i=0; i< s.length(); i++){
            if (i%2 == 0){
                stb1.append(s.charAt(i));
            } else {
                stb2.append(s.charAt(i));
            }
        }

        return stb1.append(stb2).toString();
    }


    public static void main(String[] args) throws Exception {

        System.out.println( convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI") );

        System.out.println( convert("AB", 2).equals("AB") );

        System.out.println( convert("ABCDEFG", 2).equals("ACEGBDF") );

    }
}
