package inPlaceLinkedListReversal;

import fastSlowPointers.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void printLinkedList(ListNode head){
        System.out.print("\n");
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode notCyclical;
        notCyclical = new ListNode(1);
        notCyclical.next = new ListNode(2);
        notCyclical.next.next = new ListNode(3);
        notCyclical.next.next.next = new ListNode(4);
        notCyclical.next.next.next.next = new ListNode(5);
        notCyclical.next.next.next.next.next = new ListNode(6);
        notCyclical.next.next.next.next.next.next = new ListNode(7);
        printLinkedList(notCyclical);
        notCyclical = reverseLinkedList(notCyclical);
        printLinkedList(notCyclical);
    }
}
