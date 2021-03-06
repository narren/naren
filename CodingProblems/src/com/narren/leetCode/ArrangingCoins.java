package com.narren.leetCode;
/**
 * 
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 * 
 * @author naren
 *
 */
public class ArrangingCoins {
	
	public static void main(String[] args) {
		System.out.println(new ArrangingCoins().arrangeCoins(100090));
	}
	public int arrangeCoins(int n) {
		int finishedSteps = 0;
		int currentStepsReq = 1;
		while(n > 0) {
			int i = n - currentStepsReq;
			 n = i;
			if(i >= 0) {
				finishedSteps++;
				currentStepsReq++;
			}
		}
		return finishedSteps;
	}
}
