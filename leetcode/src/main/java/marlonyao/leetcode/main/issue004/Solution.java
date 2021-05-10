package marlonyao.leetcode.main.issue004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        MedianValue medianValue = MedianValue.create(nums1.length + nums2.length);
        for (; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
                if (medianValue.record(nums1[i - 1], i + j - 1)) {
                    break;
                }
            } else {
                j++;
                if (medianValue.record(nums2[j - 1], i + j - 1)) {
                    break;
                }
            }
        }
        for (; i < nums1.length; ) {
            i++;
            if (medianValue.record(nums1[i - 1], i + j - 1)) {
                break;
            }
        }
        for (; j < nums2.length; ) {
            j++;
            if (medianValue.record(nums2[j - 1], i + j - 1)) {
                break;
            }
        }

        return medianValue.result();
    }

    static abstract class MedianValue {
        int length;

        public MedianValue(int length) {
            this.length = length;
        }

        static MedianValue create(int length) {
            if (length % 2 == 0) {
                return new EvenMedianValue(length);
            }
            return new OddMedianValue(length);
        }

        public abstract boolean record(int value, int pos);

        public abstract double result();
    }

    static class EvenMedianValue extends MedianValue {
        int value1;
        int value2;

        public EvenMedianValue(int length) {
            super(length);
        }

        public boolean record(int value, int pos) {
            if (pos == length / 2) {
                value2 = value;
                return true;
            } else if (pos == length / 2 - 1) {
                value1 = value;
            }
            return false;
        }

        public double result() {
            return (value1 + value2) / 2.0;
        }
    }

    static class OddMedianValue extends MedianValue {
        private int value1;

        public OddMedianValue(int length) {
            super(length);
        }

        public boolean record(int value, int pos) {
            if (pos == length / 2) {
                value1 = value;
                return true;
            }
            return false;
        }

        public double result() {
            return value1;
        }
    }
}
