package info.sandroalmeida;

import java.util.Arrays;

public class MoveZeroes_V2 {

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != j){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
