package info.sandroalmeida;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int pZero = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && pZero == -1){
                pZero = i;
            }
            if(nums[i] != 0 && pZero != -1) {
                int temp = nums[i];
                nums[i] = nums[pZero];
                nums[pZero] = temp;
                i = pZero;
                pZero = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
