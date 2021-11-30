package info.sandroalmeida;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i])
                j--;
            swap(i, j, nums);
        }
        reverse(nums, i+1, nums.length - 1);

    }

    private static void reverse(int[] nums, int i, int j) {
        while(i < j){
            swap(i++, j--, nums);
        }
    }

    private static void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int i : nums)
            System.out.print(i + " ");
    }
}
