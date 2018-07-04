package excersices;

public class test {

    static int dostuff(){
        return Integer.parseInt(String.valueOf('x'));
    }

    public static void main(String[] args) throws Exception {


        int[] tickets = {2,6,3,4,5};

        /*rotateArray(tickets);
        for(int i : tickets) {
            System.out.print(i);
        }
        System.out.println("\n");*/


        System.out.println(waitTime(tickets, 2));

        tickets = new int[]{5, 5, 2, 3};
        System.out.println(waitTime(tickets, 3));

        tickets = new int[]{5, 2, 2, 3};
        System.out.println(waitTime(tickets, 3));

    }

    static long waitTime(int[] tickets, int p){

        long maxTime = tickets.length * tickets[p]; // 15

        maxTime = maxTime - (tickets.length-1 - p);

        return (long) (maxTime - lessThanX(tickets, tickets[p], p));

    }


    static int lessThanX(int[] tickets, int x, int p){
        int nless = 0;
        for(int i=0; i<p; i++){
            if(tickets[i] < x)
                nless = nless + x - tickets[i];
        }
        return nless;
    }

    static void rotateArray(int[] tickets){

        int tmp = 0;
        for(int i=0; i<tickets.length; i++){

            if (i==0)
                tmp = tickets[i];

            if(i==tickets.length-1){
                tickets[i] = tmp;
            } else {
                tickets[i] = tickets[i+1];
            }
        }

    }

    public static void badMothod()
    {
        throw new RuntimeException();
    }

}
