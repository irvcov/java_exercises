package excersices;

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class add2Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n;
        int carry = 0;

        if((l1.val+l2.val) < 10){
            n = new ListNode(l1.val+l2.val);
        }else{
            carry = 1;
            n = new ListNode(l1.val+l2.val-10);
        }

        ListNode r = n;

        if(l1.next == null && l2.next == null){
            if(carry == 1){
                ListNode nd = new ListNode(1);
                n.next = nd;
            }
            return n;
        }else{
            l1 = l1.next;
            l2 = l2.next;
        }


        while(l1 != null || l2 != null){

            ListNode nd;

            int val1 = 0, val2 = 0;

            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }

            if(val1+val2+carry < 10){
                nd = new ListNode(val1+val2+carry);
                carry = 0;
            }else{
                nd = new ListNode(val1+val2+carry-10);
                carry = 1;
            }
            n.next = nd;
            n = n.next;
        }

        if(carry == 1){
            ListNode nd = new ListNode(1);
            n.next = nd;
        }

        return r;
    }


    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

}
