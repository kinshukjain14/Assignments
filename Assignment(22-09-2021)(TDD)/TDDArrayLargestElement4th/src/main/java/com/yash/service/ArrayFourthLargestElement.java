package com.yash.service;

import java.util.Arrays;

public class ArrayFourthLargestElement {

	public int getFourthLargest(int[] inputArr, int index) {
		try {
			if (index > inputArr.length) {
				throw new NegativeArraySizeException("Index value cannot be negative");
			}
			if (inputArr.length < index) {
				return 0;
			}
			Arrays.sort(inputArr);
			return inputArr[inputArr.length - index];
		} catch (NegativeArraySizeException e) {
			e.getMessage();
		}
		return 0;
	}

}
