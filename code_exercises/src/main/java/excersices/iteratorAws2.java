package excersices;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class iteratorAws2 {

    private List<Iterator> iteratorList;
    private int [] arrayIterator;
    private Iterator currentInterator;
    private int index = -1;
    private int len;

    public iteratorAws2(List<Iterator> iteratorList) {
        this.len = iteratorList.size();
        this.arrayIterator = new int[this.len];
        this.iteratorList = iteratorList;
    }

    public int next() {
        int val;

        do {
            index++;

            if (index >= len) {
                index = 0;
            }

            currentInterator = this.iteratorList.get(index);

            val = 0;
            if (currentInterator.hasNext()) {
                val = ((Integer) currentInterator.next()).intValue();
            } else {
                arrayIterator[index]++;
            }

            if (!hasNext())
                break;

        } while (arrayIterator[index] >= 1);

        return val;
    }

    public boolean hasNext() {
        int inc = 0;
        for (int i : arrayIterator) {
            if (i == 0)
                if (inc > this.len-1 && !currentInterator.hasNext())
                    return false;
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(4);
        list1.add(7);
        Iterator i1 = list1.iterator();

        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(5);
        //list2.add(9);
        Iterator i2 = list2.iterator();

        List<Integer> list3 = new LinkedList<>();
        list3.add(3);
        list3.add(6);
        list3.add(8);
        Iterator i3 = list3.iterator();

        List<Iterator> listAWS = new LinkedList<>();
        listAWS.add(i1);
        listAWS.add(i2);
        listAWS.add(i3);

        iteratorAws2 itAws = new iteratorAws2(listAWS);

        int inc = 0;
        while (itAws.hasNext()) {
            System.out.print(itAws.next());
            System.out.println(" ," + String.valueOf(inc));
            inc++;
        }


    }

}
