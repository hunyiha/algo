package array_and_linkedlist;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 19:10
 */
public class array {

    /*随机访问元素*/
    public static int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回随机元素
        return nums[randomIndex];
    }

    /* 在数组的索引 index 处插入元素 num */
    public void insert(int[] nums, int num, int index) {
        // 将index以后的数值都后移一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // 将 num 赋给 index 处的元素
        nums[index] = num;
    }

    /* 删除索引 index 处的元素 */
    public void remove(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            nums[index] = nums[index + 1];
        }
    }

    /* 遍历数组 */
    public void traverse(int[] nums) {
        // 通过索引遍历数组
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        // 直接遍历数组元素
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /* 在数组中查找指定元素 */
    public int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }


    /* 扩展数组长度 */
    public int[] extend(int[] nums, int enlarge){
        // 初始化一个扩展长度后的数组
        int[] res =  new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // 返回扩展后的新数组
        return res;
    }
}
