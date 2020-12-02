import java.util.Map;
import java.util.HashMap;

public class CopyRandomList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(10);
        ListNode temp = head;
        temp = temp.next;
        temp.next = new ListNode(16);
        temp.random = new ListNode(77);
        ListNode rand = temp.random;
        temp = temp.next;
        temp.next = rand;

        ListNode cloned = copyList(head);

        while(cloned != null) {
            System.out.println("val: " + cloned.val + " next: " + cloned.next + " random: " + cloned.random);
            cloned = cloned.next;
        }

        while(head != null) {
            System.out.println("val: " + head.val + " next: " + head.next + " random: " + head.random);
            head = head.next;
        }
    }

    public static ListNode copyList(ListNode head) {
        Map<ListNode, ListNode> nodeMap = new HashMap<>();

        ListNode temp = head;
        while(temp != null) {
            nodeMap.put(temp, new ListNode(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            ListNode clone = nodeMap.get(temp);
            if (temp.next != null) clone.next = nodeMap.get(temp.next);
            if (temp.random != null) clone.random = nodeMap.get(temp.random);
            temp = temp.next;
        }

        return nodeMap.get(head);
    }
}