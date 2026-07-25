class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : map.values()) {
            int m = list.size();
            if (m == 1) continue;

            long total = 0;
            for (int idx : list) total += idx;

            long leftSum = 0;
            long rightSum = total;

            for (int i = 0; i < m; i++) {
                int idx = list.get(i);
                rightSum -= idx;

                long left = (long) idx * i - leftSum;
                long right = rightSum - (long) idx * (m - i - 1);

                ans[idx] = left + right;

                leftSum += idx;
            }
        }

        return ans;
    }
}