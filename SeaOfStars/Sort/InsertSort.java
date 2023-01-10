package src.algorithm.sort;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertSort {

    private List<Integer> nums;

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    public void insertSort() {
        if (CollectionUtils.isEmpty(nums)) {
            return;
        }
        int length = nums.size();
        // length - 1 次循环
        for (int i = 1; i < length; ++i) {
            // 待插入数据
            int temp = nums.get(i);
            int j = i - 1;
            // 由后->前，比temp大的数后移，直至找到第一个小于等于temp数的位置
            while (j >= 0 && nums.get(j) > temp) {
                nums.set(j + 1, nums.get(j));
                --j;
            }
            nums.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {9, 0, 100, -7, -678, 89};
        InsertSort insertSort = new InsertSort();
        insertSort.setNums(Arrays.stream(arrays).boxed().collect(Collectors.toList()));
        insertSort.insertSort();
        for (int num : insertSort.nums) {
            System.out.print(num + "  ");
        }
    }

}
