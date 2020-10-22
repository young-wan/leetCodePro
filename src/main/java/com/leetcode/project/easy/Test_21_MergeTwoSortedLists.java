package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/20 2019 15:12
 * {@link} https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Test_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;


        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        System.out.println(mergeTwoLists(l1, l2, 0).toString());
    }
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


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2, int num) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2, ++num);
            System.out.printf("num---%d:\n", num);
            System.out.printf("l1---%s:\n", l1.toString());
            System.out.println();
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next, ++num);
            System.out.printf("num---%d:\n", num);
            System.out.printf("l2---%s:\n", l2.toString());
            System.out.println();
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
