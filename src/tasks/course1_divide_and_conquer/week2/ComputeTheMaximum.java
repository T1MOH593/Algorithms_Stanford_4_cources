package tasks.course1_divide_and_conquer.week2;

public class ComputeTheMaximum {

    public static int findMaximum(int[] nums) {
        int i = (nums.length - 1) / 2;
        int next = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        while (true) {
            int current = nums[i];
            if (nums.length > i + 1) {
                next = nums[i + 1];
            } if (i - 1 > -1) {
                prev = nums[i - 1];
            }

            if (current < next) {
                i =(int) ((i + 1) * 1.5 - 1);
            } else if (current < prev) {
                i = (int) ((i + 1) * 0.5 - 1);
            } else {
                return current;
            }
        }
    }
}
