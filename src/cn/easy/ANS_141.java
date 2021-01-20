package cn.easy;

/**
 * @author fubibo
 * @create 2021-01-01 20:15
 */

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 `pos` 是 `-1`，则在该链表中没有环。
 *
 * 示例：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
class LNode{
    int value;
    LNode next;
    public LNode(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "LNode{" +
                "value=" + value +
                '}';
    }
}
public class ANS_141 {
    public static void main(String[] args) {

        LNode n1=new LNode(3);
        LNode n2=new LNode(2);
        LNode n3=new LNode(0);
        LNode n4=new LNode(-1);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;

        System.out.println(hasCircle(n1));


    }

    public static boolean hasCircle(LNode head){
        if (head.next==null){
            return false;
        }

        LNode slow=head;
        LNode fast=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }

        }
        return false;







    }
}
