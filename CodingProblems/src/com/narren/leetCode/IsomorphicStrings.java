package com.narren.leetCode;

/**
 * 
https://leetcode.com/problems/isomorphic-strings/
 * 
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 * 
 * @author naren
 *
 */
public class IsomorphicStrings {

	static boolean isIsomorphic(String s, String t) {
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		
		char[] sRef = new char[128];
		char[] tRef = new char[128];
		
		for(int i = 0; i < sChar.length; i++) {
			if(sRef[sChar[i]] == '\u0000' && tRef[tChar[i]] == '\u0000') {
				sRef[sChar[i]] = tChar[i];
				tRef[tChar[i]] = sChar[i];
			}
			
			if(sRef[sChar[i]] != tChar[i] || tRef[tChar[i]] != sChar[i]) {
				return false;
			}
		}
		return true;
	}
}
