package src.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    private List<Integer> nums;

    public void swap(int i, int j) {
        // todo: 边界处理

        // swap
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);

    }

    public void quickSort(int l, int r) {
        int left = l;
        int right = r;
        if (left >= right) {
            return;
        }
        int key = nums.get(left);
        while (left < right) {
            // 后 -> 前，找第一个小于key
            while (left < right && nums.get(right) >= key) {
                --right;
            }
            // 前 -> 后，找第一个大于key
            while (left < right && nums.get(left) <= key) {
                ++left;
            }
            if (left < right) {
                swap(left, right);
            }
        }
        // key放在基准位置
        swap(l, left);
        quickSort(l, left - 1);
        quickSort(left + 1, r);
    }

    public static void main(String[] args) {
        int[] arrays = {9, 0, 100, -7, -678, 89};
        QuickSort quickSort = new QuickSort();
        quickSort.setNums(Arrays.stream(arrays).boxed().collect(Collectors.toList()));
        quickSort.quickSort(0, quickSort.getNums().size() - 1);
        for (int num : quickSort.nums) {
            System.out.print(num + "  ");
        }
    }

}
