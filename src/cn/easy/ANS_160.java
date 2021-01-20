package cn.easy;

/**
 * @author fubibo
 * @create 2021-01-01 18:48
 */

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */

class INode{
    int value;
    INode next;
    public INode(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "INode{" +
                "value=" + value +
                '}';
    }
}


public class ANS_160 {
    public static void main(String[] args) {
        INode n1=new INode(1);
        INode n2=new INode(3);
        INode n3=new INode(5);
        INode n4=new INode(6);
        INode n5=new INode(0);
        INode n6=new INode(2);
        INode n7=new INode(4);

        //1->3->5->6
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        //0->2->4->5->6
        n5.next=n6;
        n6.next=n7;
        n7.next=n3;

        System.out.println(findTwoList(n1,n5));



    }

    public static INode findTwoList(INode headA,INode headB){

        INode pa=headA;
        INode pb=headB;
        while (pa!=pb) {
            if (pa!=null){
                pa=pa.next;
            }else{
                pa=headB;
            }

            if (pb!=null){
                pb=pb.next;
            }else{
                pb=headA;
            }


        }




        return pa;
    }
}
