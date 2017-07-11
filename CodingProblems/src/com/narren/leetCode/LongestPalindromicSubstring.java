package com.narren.leetCode;
/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 * 
 * @author nsbisht
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int[] index = new int[2];
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			for(int j = chars.length - 1; j > i; j--) {
				if(isPalindrome(chars, i, j)) {
					if(j - i > index[1] - index[0]) {
						index[0] = i;
						index[1] = j;
						break;
					}
				}

			}
		}

		String ret = "";
		for(int i = index[0]; i <= index[1]; i++) {
			ret += s.substring(i);
		}
		return ret;
	}


	boolean isPalindrome(char[] c, int s, int e) {
		while(s < e) {
			if(c[s] != c[e]) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}