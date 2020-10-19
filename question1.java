package part1;
import java.util.*;
public class question1 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println(optimal(nums));
	}
	
	public static String optimal(int[] nums) {
		int pivot = -1;
		boolean isOdd = (nums.length%2 != 0);
		boolean isGoodLength = (isOdd && (nums.length - 1)%4 == 0) || (!isOdd && nums.length % 4 == 0);
		if(isOdd && isGoodLength) pivot = nums.length/2 - 1;
		else if(isOdd && !isGoodLength) pivot = (nums.length + 1)/2;
		else if(!isOdd && isGoodLength) pivot = nums.length/2;
		else pivot = (nums.length+2)/2;
		boolean toggle = false;
		for(int i = 0; i < nums.length - 1; i += 2) {
			if(!toggle && i >= pivot) {	
				toggle = true;
				if(isOdd)
					i += 1;
			}
			if(toggle) {
				nums[i+1] += nums[i];
				continue;
			}
			swap(i, i + 1, nums);
		}
		return Arrays.toString(nums);
	}
	
	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
