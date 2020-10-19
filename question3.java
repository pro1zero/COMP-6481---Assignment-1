package part1;

public class question3 {

	public static void main(String[] args) {
		int[] nums = {20, 52,400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20};
		minMax(nums);
	}
	
	public static void minMax(int[] nums) {
		int[] minIndices = {0, 1};
		int[] maxIndices = {0, 1};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length - 1; i++) {
			if(Math.abs(nums[i] - nums[i + 1]) < min) {
				min = Math.abs(nums[i] - nums[i + 1]);
				minIndices[0] = i;
				minIndices[1] = i + 1;
			}
			if(Math.abs(nums[i] - nums[i + 1]) > max) {
				max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
				maxIndices[0] = i;
				maxIndices[1] = i + 1;
			}
		}
		System.out.println("The two conductive indices with smallest difference between their values are: index " + minIndices[0] + 
				"and " + minIndices[1] + ", storing values: " + nums[minIndices[0]] + " and " + nums[minIndices[1]]);
		System.out.println("The two conductive indices with largest difference between their values are: index " + maxIndices[0] + 
				"and " + maxIndices[1] + ", storing values: " + nums[maxIndices[0]] + " and " + nums[maxIndices[1]]);
	}

}
