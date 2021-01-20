package cn.easy;

/**
 * @author fubibo
 * @create 2021-01-01 22:34
 */
public class ListNode {
    int value;
    ListNode next;
    public ListNode(int value){
        this.value=value;

    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
