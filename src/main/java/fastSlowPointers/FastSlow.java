package fastSlowPointers;

public class FastSlow {

    //easy
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    //medium
    public static ListNode startOfCyclicalList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                cycleLength = getCycleLength(slow);
                break;
            }
        }
        return getCycleStart(cycleLength, head);
    }

    public static ListNode getCycleStart(int cycleLength, ListNode head){
        ListNode pointer = head;
        while (cycleLength > 0){
            pointer = pointer.next;
            cycleLength--;
        }
        while (!pointer.equals(head)){
            head = head.next;
            pointer = pointer.next;
        }
        return pointer;
    }


    public static int getCycleLength(ListNode slow) {
        int length = 0;
        ListNode pointer = slow;
        do {
            pointer = pointer.next;
            length++;
        }
        while (!pointer.equals(slow));
        return length;
    }


    public static boolean happyNumber(int number){
        int fast = number, slow = number;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (fast != slow);
        return slow == 1;
    }

    private static int findSquareSum(int number){
        int sum = 0;
        while (number > 0){
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

}
