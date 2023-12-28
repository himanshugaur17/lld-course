package single.resp.principle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxScore(int s, int e, int k, int[] a) {
        if (s == e) {
            if (k >= 1)
                return a[s];
            else
                return 0;
        }
        if (k < 0)
            return 0;
        return Math.max(a[s] + maxScore(s + 1, e, k - 1, a), a[e] + maxScore(s, e - 1, k - 1, a));

    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        long[] prefix = new long[k + 1];
        if (k >= n)
            return Arrays.stream(cardPoints).sum();
        prefix[0] = 0;
        for (int i = 1; i <= k; i++)
            prefix[i] = prefix[i - 1] + cardPoints[i - 1];
        long maxSum = 0, suffixSum = 0;
        for (int i = 0; i <= k; i++) {
            maxSum = Math.max(maxSum, prefix[k - i] + suffixSum);
            suffixSum += cardPoints[n - i - 1];
        }
        return (int) maxSum;
    }
}