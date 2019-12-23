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

---

--12/14--

7. Write a function to find the longest common prefix in an array of strings.Returns an empty string "" if no common prefix exists.
```
Example 1:
	Input: [" flower ", "flow", "flight"]
	Output: "fl"
Example 2:
	Input: [" dog ", "racecar", "car"]
	Output: ""
Explanation: 
	there is no common prefix for the input.
Description:
	All input contains only the lowercase letters a-z.
```

Solution:
* My idea is to take the character of the first string as the longest similar string, and then pass in the other strings separately for comparison, reducing the length of the string.

---

--12/15--

8.	Given a string containing only '(', ')', '{', '}', '[', ']', determine whether the string is valid.Valid string must satisfy:The open parenthesis must be closed with the same type of close parenthesis.The open brackets must be closed in the correct order.Note that an empty string can be considered a valid string.
```
Example 1:
	Input: "()"
	Output: true
Example 2:
	Input: "[] {} ()"
	Output: true
Example 3:
	Input: "[]"
	Output: false
Example 4:
	Input: "(())"
	Output: false
Example 5:
	Input: {} [] ""
	Output: true
```
Note: 
* adding and subtracting does not match characters like "({)}". This will result in incorrect results.
Solution

Solution
* The method of push and push is used to match one by one
```java
public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.empty();
    }
```
---

--12/16--

9. Given a sorted array, you need to remove duplicate elements in place, so that each element appears only once, and return the new length of the removed array.Do not use extra array space, you must modify the input array in place and do so using O(1) extra space.
```
Example 1:
	Given the array nums = [1,1,2],The function should return the new length 2, and the first two elements of the original array nums are changed to 1, 2. You don't have to worry about the elements in the array that come after the new length.
Example 2:
	Given nums = [0,0,1,1, 2,2,3,3,4],The function should return the new length 5, and the first five elements of the original array nums are modified to be 0, 1, 2, 3, and 4.You don't have to worry about the elements in the array that come after the new length.
```

Description:
* Why is the return value an integer, but the output answer an array?
* Note that the input array is passed as a "reference," which means that modifying the input array in the function is visible to the caller.You can imagine the internal operation as follows:
```java
// nums is passed by reference.That is, no copies of the arguments are made
int len = removeDuplicates (nums);

// modifying the input array in the function is visible to the caller.
// based on the length returned by your function, it will print out all the elements in the array within that length range.
for (int I = 0;I < len.I++) {
	print (nums [I]);
}
```
10. Given an array of nums and a value of val, you need to remove all elements equal to val in place and return the new length of the array.Do not use extra array space, you must modify the input array in place and do so using O(1) extra space.The order of the elements can be changed.You don't have to worry about the elements in the array that come after the new length.
```
Example 1:
	Given nums = [3,2,2,3], val = 3,The function should return the new length 2 and the first two elements in nums are both 2.You don't have to worry about the elements in the array that come after the new length.
Example 2:
	Given nums = [0,1,2,2,3,0,4,2], val = 2,The function should return the new length 5 and the first five elements in nums are 0, 1, 3, 0, and 4.Note that the five elements can be in any order.You don't have to worry about the elements in the array that come after the new length.
```
Description:Why is the return value an integer, but the output answer an array?Note that the input array is passed as a "reference," which means that modifying the input array in the function is visible to the caller.You can imagine the internal operation as follows:
```java
// nums is passed by reference.That is, no copies of the arguments are made
int len = removeElement(nums, val);
// modifying the input array in the function is visible to the caller.
// based on the length returned by your function, it will print out all the elements in the array within that length range.
for (int I = 0;I < len.I++) {
	print (nums [I]);
}
```

Solution(both of them):
1. Sort the array
2. Judge items one by one.

---

--12/17--

11. Implement the strStr() function.Given a haystack string and a needle string, find the first place in the haystack string where the needle string appears (starting at 0).If it does not exist, it returns -1.
```
Example 1:
	Input: haystack = "hello", needle = "ll"
	Output: 2
Example 2:
	Input: haystack = "aaaaa", needle = "bba"
	Output: 1
```
Description:
* What value should we return when the needle is an empty string?This is a good question to ask in an interview.
* For this example, we should return 0 when needle is an empty string.This is consistent with the C language's STRSTR () and Java's indexOf() definitions.

---

--12/18--

12. Given the logarithm of n for generating parentheses, write a function that generates all possible and valid combinations of parentheses.
``` java
//for example, given n = 3, the resulting result is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

Solution: This is a template for solving random combinations, using two methods：
1. Violent generation + verification
2. Retrospective method to judge the opening and closing of parentheses
**By the way, solving permutations and combinations doesn't list all permutations, it excludes everything from 0 to n.**

---

--12/19--

13. Given a sorted array and a target value, find the target value in the array and return its index.If the target value does not exist in the array, returns where it will be inserted sequentially.You can assume that there are no duplicate elements in the array.
```
Example 1:
	Input: [1,3,5,6], 5
	Output: 2
Example 2:
	Input: [1,3,5,6], 2
	Output: 1.
Example 3:
	Input: [1,3,5,6], 7
	Output: 4
Example 4:
	Input: [1,3,5,6], 0
	Output: 0
```

Solution: 
Core ideas:
1. Walk through several groups to compare elements
2. Insert positionMethod 
3. methods:
	* the cycle of violenceMethod 
	* **binary search method**

---

--12/20--

14. Given a string containing only upper and lower case letters and Spaces, return the length of its last word.Return 0 if the last word does not exist.Explanation: a word is a string of letters that does not contain any Spaces.
```
Example:
	Type: "Hello World"
	Output: 5
```

Solution:
1. Exclude all empty strings
2. Remove the first space
3. Find the position where the last space appears and truncate the string

---

--12/21--

15. Given an integer array nums, find a contiguous subarray with a maximum sum (subarray containing at least one element) and return its maximum sum.
```
Example:
	Input: [-- 2, 1, 3, 4, 1, 2, 1, 5, 4].
	Output: 6
```
Explanation: the sum of consecutive subarrays [4,-1,2,1] is maximum, 6.Advanced:If you've done O(n) complexity, try a more sophisticated divide-and-conquer solution.

Solution:
1. Violent traversal
2. Greedy algorithms
3. Ka algorithm 

---

--12/22--

16. Given an array of non-empty integers, each element appears twice except for one.Find the element that only appears once.Description:Your algorithm should have linear time complexity.Can you do this without using extra space?
```
Example 1:
	Input: [2, 2, 1]
	Output: 1
Example 2:
	Input:,1,2,1,2 [4]
	Output: 4
```

Solution:
1. Compare several groups of violence
2. Xor!It's the same thing that's going to make it either zero or zero