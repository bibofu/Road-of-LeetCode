package cn.medium;

/**
 * @author fubibo
 * @create 2020-11-27 14:55
 */


/**
 * 反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */

class ListNode{

    public int value;
    public ListNode(int value) {
        this.value=value;
    }
    public ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + value +
                ", next=" + next +
                '}';
    }
}
public class ANS_92 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        ListNode res=reverseBetween(n1,2,4);
        System.out.println(res);

    }



    public static ListNode reverseBetween(ListNode head,int m,int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        ListNode pre;
        ListNode front=null;
        ListNode last;
        for (int i=1; i<m;++i){
            cur=cur.next;
        }
        pre=cur;
        last=cur.next;
        for (int i = m; i <=n; ++i) {
            cur=pre.next;
            pre.next=cur.next;
            cur.next=front;
            front=cur;
            

        }
        cur=pre.next;
        pre.next=front;
        last.next=cur;
        return dummy.next;

    }


}
