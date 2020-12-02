public class MergeKLists {
    public static void main(String[] args) {
        ListNode in1 = new ListNode(1);
        ListNode t1 = in1;
        t1.next = new ListNode(4);
        t1 = t1.next;
        t1.next = new ListNode(7);
        t1 = t1.next;
        t1.next = new ListNode(10);
        t1 = t1.next;
        t1.next = new ListNode(12);
        t1 = t1.next;

        ListNode in2 = new ListNode(2);
        t1 = in2;
        t1.next = new ListNode(3);
        t1 = t1.next;
        t1.next = new ListNode(6);
        t1 = t1.next;
        t1.next = new ListNode(11);
        t1 = t1.next;
        t1.next = new ListNode(17);
        t1 = t1.next;

        ListNode in3 = new ListNode(0);
        t1 = in3;
        t1.next = new ListNode(5);
        t1 = t1.next;
        t1.next = new ListNode(8);
        t1 = t1.next;
        t1.next = new ListNode(9);
        t1 = t1.next;
        t1.next = new ListNode(19);
        t1 = t1.next;

        ListNode in4 = new ListNode(20);
        t1 = in4;
        t1.next = new ListNode(22);
        t1 = t1.next;
        t1.next = new ListNode(77);
        t1 = t1.next;

        ListNode[] inputs = new ListNode[] {in1, in2, in3, in4};

        ListNode merged = mergeLists(inputs);

        while (merged != null) {
            System.out.print(merged.val + ", ");
            merged = merged.next;
        }
    }

    public static ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length - 1);
    }

    private static ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
}