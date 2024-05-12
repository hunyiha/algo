package array_and_linkedlist;

import java.util.Arrays;

/**
 * @author: hunyiha
 * @create-date: 2024-05-12 21:08
 */
public class MyList {

    // 用于存储数据
    private int[] arr;

    // 列表容量
    private int capacity = 10;

    // 列表长度（当前元素数量）
    private int size = 0;

    // 每次列表扩容的倍数
    private int extendRatio = 2;

    /* 无参构造 */
    public MyList() {
        arr = new int[capacity];
    }

    /* 获取列表长度（当前元素数量） */
    public int size() {
        return size;
    }

    /* 获取列表容量 */
    public int capacity() {
        return capacity;
    }

    /* 访问元素 */
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    /* 更新元素 */
    public void set(int index, int num) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        arr[index] = num;
    }

    /* 在尾部添加元素 */
    public void add(int num) {
        if (size == capacity) {
            // 元素数量超出容量时，触发扩容机制
            extendCapacity();
        }
        arr[size] = num;
        // 更新元素数量
        size++;
    }


    /* 在中间插入元素 */
    public void insert(int index, int num) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        // 元素数量超出容量时，触发扩容机制
        if (size == capacity()) {
            extendCapacity();
        }

        // 将索引 index 以及之后的元素都向后移动一位
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = num;
        // 更新元素数量
        size++;
    }


    /* 删除元素 */
    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        int num = arr[index];
        // 将将索引 index 之后的元素都向前移动一位
        for (int i = index; i < size -1; i++) {
            arr[i] = arr[i+1];
        }
        // 更新元素数量
        size--;
        // 返回被删除的元素
        return num;
    }

    /* 列表扩容 */
    public void extendCapacity() {
        // 新建一个长度为原数组 extendRatio 倍的新数组，并将原数组复制到新数组
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        // 更新列表容量
        capacity = arr.length;
    }

    /* 将列表转换为数组 */
    public int[] toArray(){
        int[] newArr =  new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
