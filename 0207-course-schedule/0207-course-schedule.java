class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Graph adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree array
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Add all courses with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int taken = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            taken++;

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // If we managed to take all courses → no cycle
        return taken == numCourses;
    }
}
