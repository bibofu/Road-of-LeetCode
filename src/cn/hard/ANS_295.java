package cn.hard;

/**
 * @author fubibo
 * @create 2021-01-04 23:24
 */

import java.util.Collections;
import java.util.PriorityQueue;

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
