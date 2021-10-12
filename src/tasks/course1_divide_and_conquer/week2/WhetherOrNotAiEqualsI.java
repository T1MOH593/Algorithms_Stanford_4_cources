package tasks.course1_divide_and_conquer.week2;

public class WhetherOrNotAiEqualsI {

    public static boolean search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int i = (left + right) / 2;
            if (i < nums[i]) {
                right = i - 1;
            } else if (i > nums[i]) {
                left = i + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
