package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        boolean res = ValidPalindrome125.isValidPalindrome("ab");
//        System.out.println(res);
//        System.out.println(ValidPalindrome125.isValidPalindrome(".a"));


//        ReverseLinkedListtwo92.ListNode listNode1 = new ReverseLinkedListtwo92.ListNode(1);
//        ReverseLinkedListtwo92.ListNode listNode2 = new ReverseLinkedListtwo92.ListNode(2);
//        ReverseLinkedListtwo92.ListNode listNode3 = new ReverseLinkedListtwo92.ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = null;
//
//        printList(listNode1);
//
//        ReverseLinkedListtwo92 solve = new ReverseLinkedListtwo92();
//        //printList(solve.reverseBetween(listNode1, 1, 3));
//        printList(solve.reverse(listNode1));


//        AddOneRowToTree.TreeNode treeNode1 = new AddOneRowToTree.TreeNode(4);
//        AddOneRowToTree.TreeNode treeNode2 = new AddOneRowToTree.TreeNode(2);
//        AddOneRowToTree.TreeNode treeNode3 = new AddOneRowToTree.TreeNode(6);
//        AddOneRowToTree.TreeNode treeNode4 = new AddOneRowToTree.TreeNode(3);
//        AddOneRowToTree.TreeNode treeNode5 = new AddOneRowToTree.TreeNode(1);
//        AddOneRowToTree.TreeNode treeNode6 = new AddOneRowToTree.TreeNode(5);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//
//        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
//
//        AddOneRowToTree.TreeNode result = addOneRowToTree.addOneRow(treeNode1, 1, 3);
//
//        result.val = 0;

//        MinFac minFac = new MinFac();
//        System.out.println(minFac.smallestFactorization(22));

//        GuessNumber375 guessNumber375 = new GuessNumber375();
//        System.out.println(guessNumber375.getMoneyAmount(4));

//        SelectColors75 selectColors75 = new SelectColors75();
//        int[] nums = {0, 1, 2, 2, 2, 1, 1, 0};
//        selectColors75.sortColors2(nums);

        MergeSortedList21 mergeSortedList21 = new MergeSortedList21();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode4;

//        mergeSortedList21.mergeTwoLists(listNode, listNode5);

//        ListNode res = mergeSortedList21.mergeLists(listNode, listNode5);
        MergeKSortedList23 mergeKSortedList23 = new MergeKSortedList23();
        ListNode[] listNodes = {listNode, listNode5};
        ListNode res = mergeKSortedList23.mergeKLists(listNodes);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
