package cn.medium;

/**
 * @author fubibo
 * @create 2021-01-03 13:36
 */

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 */


class Rnode{
    int value;
    Rnode random;
    Rnode next;
    public Rnode(){

    }
    public Rnode(int value){
        this.value=value;
        this.next=null;
        this.random=null;
    }

    @Override
    public String toString() {
        return "Rnode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class ANS_138 {


    HashMap<Rnode,Rnode> visitedHash=new HashMap<>();

    public  Rnode copyList(Rnode head){
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Rnode node = new Rnode(head.value);

        this.visitedHash.put(head, node);
        node.next = this.copyList(head.next);
        node.random = this.copyList(head.random);

        return node;


    }

    public Rnode copyRandomList(Rnode head) {

        if (head == null) {
            return null;
        }

        Rnode ptr = head;
        while (ptr != null) {
            Rnode newNode = new Rnode(ptr.value);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Rnode ptrOldList = head;
        Rnode ptrNewList = head.next;
        Rnode headOld = head.next;
        while (ptrOldList != null) {
            ptrOldList.next = ptrOldList.next.next;
            assert ptrNewList != null;
            ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }
        return headOld;
    }


    @Test
    public void test() {

        Rnode n1=new Rnode(1);
        Rnode n2=new Rnode(2);
        Rnode n3=new Rnode(3);
        Rnode n4=new Rnode(4);
        Rnode n5=new Rnode(5);

        n1.next=n2;
        n1.random=n3;

        n2.next=n3;
        n2.random=n1;

        n3.next=null;
        n3.random=null;

        System.out.println(copyList(n1));

        System.out.println(copyRandomList(n1));




    }


}
