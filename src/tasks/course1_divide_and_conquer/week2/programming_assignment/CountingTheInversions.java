package tasks.course1_divide_and_conquer.week2.programming_assignment;

public class CountingTheInversions {

    public static Result sortAndCount(int[] nums) {
        if (nums.length == 1) {
            return new Result(0, nums);
        }
        int[] left = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[(nums.length + 1) / 2];
        for (int i = nums.length / 2; i < nums.length; i++) {
            right[i - nums.length / 2] = nums[i];
        }

        Result leftResult= sortAndCount(left);
        Result rightResult = sortAndCount(right);
        Result splitResult = mergeAndCountSplitInversions(leftResult.getArray(), rightResult.getArray());

        return new Result(leftResult.getInversions() + rightResult.getInversions() + splitResult.getInversions(), splitResult.getArray());
    }

    public static Result mergeAndCountSplitInversions(int[] left, int[] right) {
        return merge(left, right, left.length, right.length);
    }

    public static Result merge(int[] left, int[] right, int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        long inversions = 0;
        int[] nums = new int[l + r];
        while (i < l && j < r) {
            if (left[i] < right[j]) {
                nums[k++] = left[i++];
            } else if (left[i] > right[j]) {
                nums[k++] = right[j++];
                inversions += left.length - i;
            }
        }
        while (i < l) {
            nums[k++] = left[i++];
        }
        while (j < r) {
            nums[k++] = right[j++];
        }
        return new Result(inversions, nums);
    }
}
