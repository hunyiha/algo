package stack_and_queue;

import utils.ListNode;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 23:14
 */
public class LinkedListQueue {

    private ListNode front, rear; // 头节点 front ，尾节点 rear

    private int queSize = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入队 */
    public void push(int num) {
        ListNode listNode = new ListNode(num);
        // 如果队列不为空，则将该节点添加到尾节点后
        if (rear != null){
            rear.next = listNode;
            rear = listNode;
        // 如果队列为空，则令头、尾节点都指向该节点
        }else {
            rear = listNode;
            front = listNode;
        }
        queSize++;
    }

    /* 出队 */
    public int pop() {
        int num = peek();
        // 删除头节点
        front = front.next;
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return front.val;
    }

    /* 将链表转化为 Array 并返回 */
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
