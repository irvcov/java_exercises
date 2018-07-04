package excersices;

import java.util.LinkedList;
import java.util.List;

public class iterator {

    private List<Integer> list;
    private int index = 0;
    private int len;

    public iterator(List<Integer> list) {
        this.list = list;
        this.len = list.size();
    }

    public int next() throws Exception {
        index++;
        if (index < len) {
            return list.get(index);
        } else {
            throw new Exception("No more items on the List.");
        }
    }

    public int current() {
        return list.get(index);
    }

    public boolean hasNext() {
        if ( (index+1) < len){
            if (list.get(index+1) != null ){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        List<Integer> list1 = new LinkedList<>();
        list1.add(5);
        list1.add(4);
        list1.add(3);

        iterator it = new iterator(list1);

        while(true){
            System.out.println(it.current());

            if (it.hasNext()) {
                it.next();
            } else {
                break;
            }
        }

    }
}
