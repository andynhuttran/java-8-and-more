/*
Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*class Solution {
    public boolean isPalindrome(ListNode head) {
        
        int count = countList(head);
        if (count <= 1) return true;
        
        boolean handlePeek = false;
        int peekIdx = -1;
        if (count%2 != 0){
            handlePeek = true;
            peekIdx = (count/2);
        }
        
        ListNode node = head;
        int idx = 0;
        Stack<Integer> stack = new Stack<Integer>();
            
        while (node != null){
            
            if (!handlePeek || peekIdx != idx){
                if (stack.size() > 0 && stack.peek() == node.val){
                    stack.pop();
                }
                else {
                    stack.push(node.val);
                }
            }
            
            node = node.next;
            idx++;
        }
        
        return stack.size() == 0;
    }
    
    public int countList(ListNode head){
        int count = 0;
        
        ListNode node = head;
        while (node != null){
            count++;
            node = node.next;
        }
        
        return count;
    }
}*/
