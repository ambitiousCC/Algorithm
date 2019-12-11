# Algorithm
Mainly in Java

--19/12/09--
1. Given an array of integers, return indices of the two numbers such that they add up to a specific target.
**You may assume that each input would have exactly one solution, and you may not use the same element twice**.

Example:
```Java
//Given 
nums = [2, 7, 11, 15], target = 9,

//Because 
nums[0] + nums[1] = 2 + 7 = 9,
//return 
[0, 1].
```

Solution:
Bubble sort traversal element violence solution, note that the return is a pair of subscripts and only one result

---

--19/12/10--

2. Given a string, find the length of the oldest string that does not contain repeating characters.
```
Example 1:
    Input: "abcabcbb"
    Output: 3
Explanation: since the oldest string without repeating characters is "ABC", its length is 3.

Example 2:
    Input: "BBBBB"
    Output: 1.Explanation: since the oldest string without repeating characters is "b", its length is 1.

Example 3:
    Input: "pwwkew"
    Output: 3
Explanation: since the oldest string without repeating characters is "wke", its length is 3.Note that your answer must be the length of the substring. "pwke" is a subroutine, not a substring.
```

Solution:
1. The non-repeating string is put into a list set, and the length of the list set is put into list2 after the end of one traversal. Finally, the length is taken out of list2 and the longest is obtained.

2. Returns the string length after maintaining the longest string from left to right
```Java
public static int lengthOfLongestSubstring(String s) {
	int maxLength = 0;
	char[] chars = s.toCharArray();
	int leftIndex = 0;
	for (int j = 0; j < chars.length; j++) {
	    for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
	    if (chars[innerIndex] == chars[j]) {
	        maxLength = Math.max(maxLength, j - leftIndex);
	        leftIndex = innerIndex + 1;
	        break;
	    }
	    }
	}
	return Math.max(chars.length - leftIndex, maxLength);
}
```
<<<<<<< HEAD

---

--12/11--
3. Determine whether an integer is a palindrome.Palindromes are integers whose positive order (from left to right) and reverse order (from right to left) are the same.
```
Example 1:
	Input: 121
	Output: true,
Example 2:
	Input: - 121
	Output: false
	Interpretation: read from left to right, minus 121.Read from right to left, that's 121 minus.So it's not a palindrome.
Example 3:
	Input: 10
	Output: false
	Explanation: read from right to left, = 01.So it's not a palindrome.
```
=======
>>>>>>> c3cff7c5fcde6bf2fc8c474ad23c1fa1b5394208
