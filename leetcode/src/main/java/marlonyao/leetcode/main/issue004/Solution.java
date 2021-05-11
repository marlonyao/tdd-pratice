package marlonyao.leetcode.main.issue004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findNth(nums1, nums2, len / 2) + findNth(nums1, nums2, len / 2 + 1)) / 2.0;
        }
        return findNth(nums1, nums2, len / 2 + 1);
    }

    int findNth(int[] a, int[] b, int nth) {
        return findNth(a, 0, a.length - 1, b, 0, b.length - 1, nth);
    }

    int findNth(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int nth) {
        if (aStart > aEnd) {
            return b[bStart + nth - 1];
        }
        if (bStart > bEnd) {
            return a[aStart + nth - 1];
        }
        if (nth == 1) {
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }

        int aHalf = Math.min(nth / 2, aEnd - aStart + 1);
        int bHalf = Math.min(nth / 2, bEnd - bStart + 1);
        if (a[aStart + aHalf - 1] < b[bStart + bHalf - 1]) {
            return findNth(a, aStart + aHalf, aEnd, b, bStart, bEnd, nth - aHalf);
        } else {
            return findNth(a, aStart, aEnd, b, bStart + bHalf, bEnd, nth - bHalf);
        }
    }
}
