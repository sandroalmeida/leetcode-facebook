package info.sandroalmeida;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int lastPosition = 0;
        int lastNumber = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != lastNumber && i == lastPosition + 1){
                lastPosition++;
                lastNumber = nums[i];
            } else if(nums[i] != lastNumber){
                lastNumber = nums[i];
                swap(i, lastPosition + 1, nums);
                lastPosition++;
            } else{
                continue;
            }
        }
        return lastPosition + 1;
    }

    private static void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
