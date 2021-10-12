package tasks.course1_divide_and_conquer.week2;

public class SecondBiggestNumber {

    public static int find(int[] nums) {
        Integer first;
        Integer second = Integer.MIN_VALUE;
        first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > first) {
                int temp = first;
                first = nums[i];
                second = temp;
            }
            else if (nums[i] > second && nums[i] < first) {
                second = nums[i];
            }
        }
        return second;
    }
}
