package cn.easy;

/**
 * @author fubibo
 * @create 2020-12-11 17:34
 */


/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ANS_206 {

    public static void main(String[] args) {
        Node n1=new Node(5);
        Node n2=new Node(4);
        Node n3=new Node(6);
        Node n4=new Node(7);
        Node n5=new Node(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        Node res=reverse(n1);
        System.out.println(res);


    }

    public static Node reverse(Node head){
        Node pre=null;
        Node cur=head;
        while (cur!=null){
            Node next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }



}

class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
