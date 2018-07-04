package excersices;

import java.util.LinkedList;
import java.util.List;

public class iteratorAws {

    private List<iterator> listIterator;
    private iterator currIterator;
    private int [] iteratorArr;
    private int index = -1;
    private int len;

    public iteratorAws(List<iterator> listIterator) {
        this.listIterator = listIterator;
        this.len = listIterator.size();
        this.iteratorArr = new int[this.len];
    }

    public int next() throws Exception {

        int val;
        do {

            index++;
            if (index >= len) {
                index = 0;
            }

            currIterator = listIterator.get(index); //next
            val = currIterator.current();
            checkIfHasNext();

            if (!hasNext()) {
                break;
            }

        } while (iteratorArr[index] > 1);

        return val;
    }

    private boolean hasNext() {
        for (int i : iteratorArr) {
            if (i == 0)
                return true;
        }
        return false;
    }

    private void checkIfHasNext() throws Exception {
        if (currIterator.hasNext()) {
            currIterator.next();
        } else {
            iteratorArr[index]++;
        }
    }

    public static void main(String[] args) throws Exception {

        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(4);
        list1.add(7);
        iterator i1 = new iterator(list1);

        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(5);
        //list2.add(9);
        iterator i2 = new iterator(list2);

        List<Integer> list3 = new LinkedList<>();
        list3.add(3);
        list3.add(6);
        list3.add(8);
        iterator i3 = new iterator(list3);

        //Iterator<Integer> ite = list1.iterator();
        //System.out.println(ite.next());

        List<iterator> listAWS = new LinkedList<>();
        listAWS.add(i1);
        listAWS.add(i2);
        listAWS.add(i3);

        iteratorAws itAws = new iteratorAws(listAWS);

        while (itAws.hasNext()) {
            System.out.println(itAws.next());
        }
    }
}
