package array_and_linkedlist;

import utils.ListNode;
import utils.PrintUtil;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 19:58
 */
public class linked_list {

    /* 在链表的节点 n0 之后插入节点 P */
    public void insert(ListNode n0, ListNode p){
        p.next = n0.next;
        n0.next = p;
    }

    /* 删除链表的节点 n0 之后的首个节点 */
    public void remove(ListNode n0) {
        if (n0.next == null){
            return;
        }
        n0.next = n0.next.next;
    }

    /* 访问链表中索引为 index 的节点 */
    public ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null){
                return null;
            }
            head = head.next;
        }
        return head;
    }

    /* 在链表中查找值为 target 的首个节点 */
    public int find(ListNode head, int target) {
        int index = 0;
        while (head != null){
            if (head.val == target){
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }



    public static void main(String[] args) {
        /* 初始化链表 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // 构建节点之间的引用
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("初始化的链表为");
        PrintUtil.printLinkedList(n0);
    }
}
