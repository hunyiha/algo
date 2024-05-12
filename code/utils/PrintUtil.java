package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 20:07
 */
public class PrintUtil {
    /* 打印链表 */
    public static void printLinkedList(ListNode head) {
        List<String> list = new ArrayList<>();
        while (head != null) {
            list.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", list));
    }
}
