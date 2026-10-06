class LinkedList {
private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
    }

    public int get(int index) {
        ListNode curr = head.next;

        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.value;
            }

            i++;
            curr = curr.next;
        }

        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head.next;
        head.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);

        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
        ListNode curr = head;

        int i = 0;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }

            curr.next = curr.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode curr = head.next;

        while (curr != null) {
            values.add(curr.value);
            curr = curr.next;
        }

        return values;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
