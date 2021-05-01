package marlonyao.leetcode.main.issue003;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // left, right；INV: s[left, right) 没有重复串。
        // - 如果 s[right] 在 s[left, right)里有，记索引为 dupIndex。left前进到 dupIndex+1，right++
        // - 否则，s[right] 在 s[left, right)找不到，right++。
        int left = 0, right = 0;
        int longest = 0;
        while (right < s.length()) {
            int dupIndex = find(s, left, right, s.charAt(right));
            if (dupIndex >= 0) {
                if ((right - left) > longest) {
                    longest = right - left;
                }
                left = dupIndex + 1;
            }
            right++;
        }
        if ((right - left) > longest) {
            longest = right - left;
        }
        return longest;
    }

    private int find(String s, int left, int right, char ch) {
        for (int i = left; i < right; i++) {
            if (s.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}
