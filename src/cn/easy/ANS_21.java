package cn.easy;

/**
 * @author fubibo
 * @create 2021-01-03 14:21
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class ANS_21 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        ListNode n4=new ListNode(1);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(4);
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        System.out.println(sortList(n1,n4));

    }

    public static ListNode sortList(ListNode head1,ListNode head2){
        ListNode newHead=new ListNode(-1);
        ListNode cur=newHead;
        while (head1!=null&&head2!=null){
            if (head1.value<=head2.value){
                cur.next=head1;
                head1=head1.next;
            }else {
                cur.next=head2;
                head2=head2.next;
            }
           cur=cur.next;

        }

        if (head1!=null){
            cur.next=head1;
        }
        if (head2!=null){
            cur.next=head2;
        }

        return newHead.next;

    }

}
