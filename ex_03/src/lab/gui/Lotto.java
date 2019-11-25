package lab.gui;

import java.util.*;

public class Lotto {

	public int[] getLotto() {
		int[] nums = new int[6];
		boolean bl = true;
		while (bl) {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (nums[i] == nums[j]) {
						i--;
						break;
					}
				}
			}
			int sum = 0;
			double mean = 0.0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			mean = (double) sum / 6;
			if (mean >= 20 && mean <= 26) {
				Arrays.sort(nums);
				bl = false;
			}

		}
		return nums;
	}

}
