package tasks.course1_divide_and_conquer.week3;

import java.util.Arrays;

public class QuickSort {

    public static int sort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }
        // CHOOSE PIVOT
        int chosenPivot = choosePivot3(nums, begin, end);
        int pivot = nums[chosenPivot];

        int temp2 = nums[begin];
        nums[begin] = nums[chosenPivot];
        nums[chosenPivot] = temp2;

        int comparisons = end - begin;
        Integer i = null;
        for (int j = begin + 1; j < end + 1; j++) {
            if (nums[j] < pivot) {
                if (i == null) {
                    i = begin + 1;
                } else {
                    i++;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (i == null) {
            i = begin;
        }

        int temp = nums[begin];
        nums[begin] = nums[i];
        nums[i] = temp;
        int comparisons1 = sort(nums, begin, i - 1);
        int comparisons2 = sort(nums, i + 1, end);

        return comparisons + comparisons1 + comparisons2;
    }

    public static int choosePivot1(int[] nums, int begin, int end) {
        return begin;
    }

    public static int choosePivot2(int[] nums, int begin, int end) {
        return end;
    }

    public static int choosePivot3(int[] nums, int begin, int end) {
        int first = nums[begin];
        int last = nums[end];
        int middle = nums[begin + (end - begin) / 2];

        int[] ints = {first, last, middle};
        Arrays.sort(ints);

        if (ints[1] == nums[begin]) {
            return begin;
        } else if (ints[1] == nums[end]) {
            return end;
        } else {
            return begin + (end - begin) / 2;
        }
    }

}
