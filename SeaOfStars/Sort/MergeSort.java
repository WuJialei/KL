package src.algorithm.sort;

import java.util.Arrays;
import java.util.Objects;

public class MergeSort {


    /**
     * 分
     * 时间复杂度：O(nLog(n)，稳定
     * 空间复杂度：O(n)
     * @param nums
     */
    public int[] divide(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return nums;
        }
        int mid = nums.length >> 1;
        int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        int[] rightNums = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(divide(leftNums), divide(rightNums));
    }

    /**
     * 合
     * @param leftNums 有序
     * @param rightNums 有序
     * @return
     */
    public int[] merge(int[] leftNums, int[] rightNums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ret = new int[leftNums.length + rightNums.length];
        while(i < leftNums.length && j < rightNums.length) {
            if (leftNums[i] < rightNums[j]) {
                ret[k++] = leftNums[i++];
            } else {
                ret[k++] = rightNums[j++];
            }
        }
        while(i < leftNums.length) {
            ret[k++] = leftNums[i++];
        }
        while(j < rightNums.length) {
            ret[k++] = rightNums[j++];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 0, 100, -7, -678, 89};
        MergeSort mergeSort = new MergeSort();
        int[] ret = mergeSort.divide(arrays);
        for (int num : ret) {
            System.out.print(num + "  ");
        }
    }

}
