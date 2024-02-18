package ds.linkedlist;

public class SearchingLinkedList {

    public boolean search(Node head, int val){

        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == val) return true;
            currentNode = currentNode.next;
        }

        return false;
    }

    public boolean searchRec(Node head, int val){

        if (head == null) return false;

        if (head.value == val) return true;

        return search(head.next, val);
    }
}
