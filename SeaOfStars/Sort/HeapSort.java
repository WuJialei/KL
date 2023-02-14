package src.algorithm.sort;

import java.util.Objects;

public class HeapSort {

    /**
     * 时间复杂度： O(nlog(n))
     * 空间复杂度： O(1)
     * @param nums
     */
    public void heapSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return;
        }
        // 建堆(升序大顶堆，降序小顶堆)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        // 从末尾元素开始，把堆顶元素与末尾元素交换，调整堆
        for (int j = nums.length - 1; j > 0; j--) {
            swap(0, j, nums);
            adjustHeap(nums, 0, j);
        }
    }

    /**
     * 保证heapRoot位置开始，符合大顶堆逻辑
     * @param nums
     * @param heapRoot
     */
    public void adjustHeap(int[] nums, int heapRoot, int len) {
        int temp = nums[heapRoot];
        for (int i = heapRoot * 2 + 1; i < len; i = i*2 + 1) {
            if (i + 1 < len && nums[i] < nums[i+1]) {
                i = i + 1;
            }
            if (nums[i] > temp) {
                nums[heapRoot] = nums[i];
                heapRoot = i;
            } else {
                break;
            }
        }
        nums[heapRoot] = temp;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 0, 100, -7, -678, 89};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arrays);
        for (int num : arrays) {
            System.out.print(num + "  ");
        }
    }

}
