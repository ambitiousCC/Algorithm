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
* Bubble sort traversal element violence solution, note that the return is a pair of subscripts and only one result

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
---

--12/11--

4. Determine whether an integer is a palindrome.Palindromes are integers whose positive order (from left to right) and reverse order (from right to left) are the same.
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

Solution:
	Converts an integer to an array of characters and compares the corresponding characters one by one.
Or you can increase difficulty:
	Take the digits by integer mod, and then compare them one by one as before.

5. Given a 32-bit signed integer, you need to invert the Numbers on each of the integers.
```
Example 1:
	Input: 123
	Output: 321
Example 2:
	Input: - 123
	Output: - 321
Example 3:
	Input: 120
	Output: 21
```
Note:
	* Given that our environment can only store 32-bit signed integers, the range is [−231, 231 − 1].Based on this assumption, return 0 if the integer overflows after inversion.

Solution:
	* The main problem is to determine whether or not to cross the line, especially after a number inversion to determine.Use: Integer. MAX_VALUE

---

--12/12--

6. Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

```
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
```

Solution:
* Notice the situation:
1. Remove Spaces before and after strings
2. Determine whether it is a single character
3. Determine if the number is out of bounds
Finally, complete the logic according to the concept of "for loop first"