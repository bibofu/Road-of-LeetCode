# LeetCode

## **一：链表**

###    1: easy

#### 1）链表交点

```java
LeetCode 160
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
```



####  2）链表反转

```java
Leetcode 206
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
```



#### 3）链表环

```java
Leetcode 141 
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
```



#### 4）链表分割

```java

Leetcode 86 
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
```



#### 5）合并有序链表

```java
Leetcode 21 
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
```













### 2: medium

#### 1）链表反转2

```java
Leetcode 92 
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
```



#### 2）随机指针链表拷贝 *

```java
Leetcode 138 

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
```





## 二：栈、队列、堆



### 1：easy

#### 1）用队列实现栈


```c++
Leetcode 225 
使用队列实现栈的下列操作：
push(x) – 元素 x 入栈
pop() – 移除栈顶元素
top() – 获取栈顶元素
empty() – 返回栈是否为空
    
    
#include <iostream>
#include <queue>
using namespace std;
class MyStack {
  public:
    queue<int> q1, q2;
    int i = 0;
    int temp;
    int res;
    MyStack() {}

    void push(int x) { q1.push(x); }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int length1 = q1.size();
        i = 0;
        while (length1 > 1 && i < length1 - 1) {
            temp = q1.front();
            q2.push(temp);
            q1.pop();
            i++;
        }
        res = q1.front();
        q1.pop();
        i = 0;
        int length2 = q2.size();
        while (i < length2) {
            temp = q2.front();
            q1.push(temp);
            q2.pop();
            i++;
        }
        return res;
    }

    /** Get the top element. */
    int top() { return q1.back(); }

    /** Returns whether the stack is empty. */
    bool empty() { return q1.empty(); }
};

int main() {
    MyStack stack;

    stack.push(1);
    stack.push(2);
    stack.push(3);
    int res = stack.pop();
    cout << res << endl;
}
```







#### 2）数组第K大数

```java
Leetcode 215 

    使用到堆
/**
 * 数组中的第K个最大元素
 * 示例1：
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2：
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class ANS_215 {
    public static void main(String[] args) {
        int[] test={3,2,1,5,6,4};
        System.out.println(findKthLargest(test,2));

    }

    public static int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i=0;i<nums.length;i++){
            if (heap.size()<k) {
                heap.add(nums[i]);
            }else if (heap.element()<nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }

        }

        return heap.poll();


    }
}
```



### 2：medium





















### 3：hard 



#### 1）寻找中位数 *

```java
Leetcode 295 

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * - void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * - double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */

class MedianFinder {
    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        //维护较大的元素的最小堆
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        //维护较小元素的最大堆
        minheap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
}
public class ANS_295 {
    public static void main(String[] args) {

        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(5);

        System.out.println(medianFinder.findMedian());

    }


}
```









## **三：贪心**

### 1：easy



#### 1）孩子分糖果

```java
LeetCode 455 

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */
public class ANS_455 {
    public static void main(String[] args) {
        int[] k={1,2};
        int[] c={1,2,3};
        System.out.println(cookie(k,c));
        
    }

    public static int cookie(int[] kids,int[] cookies){
        Arrays.sort(kids);
        Arrays.sort(cookies);
        int kidIndex=0;
        int cookieIndex=0;
        int count=0;
        while (kidIndex<kids.length&&cookieIndex<cookies.length) {
            if (kids[kidIndex] <=cookies[cookieIndex]) {
                kidIndex++;
                count++;
            }
            cookieIndex++;
        }

        return count;
    }
}
```

















### 2：medium

#### 1）摆动序列

```java
Leetcode 376 

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 */
public class ANS_376 {
    public static void main(String[] args) {

        int[] test={1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(test));

    }

    public static int wiggleMaxLength(int[] nums){
        if (nums.length<=2){
            return nums.length;
        }


        final int BEGIN=0;
        final int UP=1;
        final int DOWN=2;
        int STATE=BEGIN;

        int maxsize=1;

        for (int i = 1; i <nums.length ; i++) {
            switch (STATE){
                case BEGIN:
                    if (nums[i-1]<nums[i]){
                        STATE=UP;
                        maxsize++;

                    }else if (nums[i-1]>nums[i]){
                        STATE=DOWN;
                        maxsize++;

                    }
                    break;

                case UP:
                    if (nums[i-1]>nums[i]){
                        STATE=DOWN;
                        maxsize++;
                    }
                    break;


                case DOWN:
                    if (nums[i-1]<nums[i]){
                        STATE=UP;
                        maxsize++;
                    }
                    break;

            }


        }



        return maxsize;
    }

}
```















### 3：hard





## **四：递归、回溯与分治**

### 1：easy

### 2：medium

### 3：hard

## **五：二叉树与图**

### 1：easy

### 2：medium

### 3：hard

## **六：二分查找与二叉排序树**

### 1：easy

### 2：medium

### 3：hard

## **七：哈希表与字符串**

### 1：easy

### 2：medium

### 3：hard

## 八：搜索

### 1：easy

### 2：medium

### 3：hard

## **九：动态规划**

### 1：easy

### 2：medium

### 3：hard

## **十：复杂数据结构**

### 1：easy

### 2：medium

### 3：hard





# 剑指offer