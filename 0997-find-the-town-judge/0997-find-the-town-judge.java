class Solution {
    public int findJudge(int n, int[][] trust) {
        // If no trust relationships and only 1 person, that person is the judge
        if (trust.length == 0 && n == 1) return 1;

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            outdegree[a]++;  // a trusts someone
            indegree[b]++;   // b is trusted by someone
        }

        for (int i = 1; i <= n; i++) {
            // Judge: trusted by everyone else (n-1) AND trusts nobody
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
