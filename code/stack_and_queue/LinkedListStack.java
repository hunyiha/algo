package stack_and_queue;

import utils.ListNode;

import java.util.LinkedList;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 22:23
 */
public class LinkedListStack {
    private ListNode stackPeek; // 将头节点作为栈顶
    private int stkSize = 0; // 栈的长度

    public LinkedListStack() {
        stackPeek = null;
    }

    // 获取栈的长度
    public int size() {
        return stkSize;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return stkSize == 0;
    }

    // 入栈
    public void push(int num) {
        ListNode listNode = new ListNode(num);
        listNode.next = stackPeek;
        stackPeek = listNode;
        stkSize++;
    }

    // 出栈
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    // 返回栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    /* 将 List 转化为 Array 并返回 */
    public int[] toArray() {
        int[] res = new int[size()];
        ListNode node = stackPeek;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
