package sort;

public class LCR078 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] list, int low, int high) {
        if(low == high) {
            return list[low];
        }
        if(low > high) {
            return null;
        }
        int mid = (low + high) >>> 1;
        return mergeTwoLists(mergeList(list, low, mid), mergeList(list, mid + 1, high));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                cur.next = a;
                a = a.next;
            }
            else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a == null? b : a;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
