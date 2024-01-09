package ds.linkedlist;

public class AddingTwoLinkedList {

    public Node addTwoNumbers(Node l1, Node l2) {

        Node nodeOne = l1;
        Node nodeTwo = l2;
        Node sumNode = new Node(0);
        Node resultNode = sumNode;
        int carry = 0;

        while (nodeOne != null || nodeTwo != null || carry != 0){
            int value1 = (nodeOne != null) ? nodeOne.value : 0;
            int value2 = (nodeTwo != null) ? nodeOne.value : 0;

            int sum = value1+value2+carry;

            carry = sum / 10;
            resultNode.next = new Node(sum % 10);

            if (nodeOne != null) nodeOne = nodeOne.next;
            if (nodeTwo != null) nodeTwo = nodeTwo.next;
            resultNode = resultNode.next;

        }

        return sumNode.next;

    }
}
