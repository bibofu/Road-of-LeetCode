package cn.easy;

/**
 * @author fubibo
 * @create 2021-01-01 22:35
 */

/**
 * 给定一个链表和一个特定值 *x*，对链表进行分隔，使得所有小于 *x* 的节点都在大于或等于 *x* 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class ANS_86 {
    public static void main(String[] args) {

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(2);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(2);

        //1->4->3->2->5->2
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        System.out.println(partitionList(n1,3));

        //1->2->2->4->3->5

    }

    public static ListNode partitionList(ListNode head,int num){
        ListNode head1=new ListNode(-1);
        ListNode head2=new ListNode(-1);

        ListNode pre1=head1;
        ListNode pre2=head2;

       // ListNode ret=new ListNode(0);

        for (ListNode cur=head;cur!=null;){
            if(cur.value < num){
                pre1.next = cur;
                cur = cur.next;
                pre1 = pre1.next;
                pre1.next = null;
            }
            else{
                pre2.next = cur;
                cur = cur.next;
                pre2 = pre2.next;
                pre2.next = null;
            }
        }

        pre1.next = head2.next;

        return head1.next;
    }





}
