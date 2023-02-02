package src.algorithm.sort;

import java.util.Objects;

public class RadixSort {


    /**
     * 仅适用于 大于0 的 整数排序
     * 时间复杂度：O(dn)，稳定
     * 空间复杂度：O(n)
     * d:位数
     *
     * @param nums
     * @return
     */
    public int[] radixSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return nums;
        }

        // 最大数
        int maxNum = nums[0];
        // 最大位数
        int maxDigit = 0;
        // 桶
        int[][] buckets = new int[10][nums.length];
        int base = 10;

        // 确认要排序的数组中的最大位数maxDigit
        for (int num : nums) {
            maxNum = num > maxNum ? num : maxNum;
        }
        while (maxNum > 0) {
            maxNum = maxNum / 10;
            ++maxDigit;
        }

        // 从最低位开始，遍历最大位数，各位数有序
        for (int i = 0; i < maxDigit; ++i) {
            // 记录本次迭代各个桶内排序数的个数
            int[] bucketLenArr = new int[10];
            // nums
            for (int j = 0; j < nums.length; ++j) {
                int bucketNo = (nums[j] % base) / (base/10);
                // 某桶某数
                buckets[bucketNo][bucketLenArr[bucketNo]] = nums[j];
                // 某桶大小
                ++bucketLenArr[bucketNo];
            }

            int cnt = 0;
            for (int e = 0; e < bucketLenArr.length; ++e) {
                for (int k = 0; k < bucketLenArr[e]; ++k) {
                    nums[cnt++] = buckets[e][k];
                }
            }

            base *= 10;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 1, 100, 7, 678, 89};
        RadixSort radixSort = new RadixSort();
        int[] ret = radixSort.radixSort(arrays);
        for (int num : ret) {
            System.out.print(num + "  ");
        }
    }


}
