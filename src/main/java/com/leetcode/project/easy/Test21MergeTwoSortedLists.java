package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/20 2019 15:12
 * {@link} https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Test21MergeTwoSortedLists {
   /*
    Merge two sorted linked lists and return it as a new list. The new list should be made by
    splicing together the nodes of the first two lists.

    Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
//
//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) {
//            return l2;
//        }
//        if(l2 == null) {
//            return l1;
//        }
//        if(l1.val <= l2.val){
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }else{
//            l2.next = mergeTwoLists(l1,l2.next);
//            return l2;
//        }
//    }
}
