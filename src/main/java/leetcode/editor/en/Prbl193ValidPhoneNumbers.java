//Given a text file file.txt that contains list of phone numbers (one per line),
// write a one liner bash script to print all valid phone numbers. 
//
// You may assume that a valid phone number must appear in one of the following 
//two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit) 
//
// You may also assume each line in the text file must not contain leading or tr
//ailing white spaces. 
//
// Example: 
//
// Assume that file.txt has the following content: 
//
// 
//987-123-4567
//123 456 7890
//(123) 456-7890
// 
//
// Your script should output the following valid phone numbers: 
//
// 
//987-123-4567
//(123) 456-7890
// 
// 👍 172 👎 445

package leetcode.editor.en;

//java: Valid Phone Numbers 
public class Prbl193ValidPhoneNumbers {
    public static void main(String[] args) {
        Solution solution = new Prbl193ValidPhoneNumbers().new Solution();
    }
    //There is no code of Java type for this problem

    class Solution {
        // Bash Code
        /*
        egrep -x '[0-9]{3}\-[0-9]{3}\-[0-9]{4}|\([0-9]{3}\) [0-9]{3}\-[0-9]{4}' file.txt
         Be careful with -x, this require reg to match the whole line.
         WA once because of 0(123) 456-7890
         */
    }
}