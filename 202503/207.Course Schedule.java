/*
 * @lc app=leetcode id=207 lang=java
 * @lcpr version=30103
 *
 * [207] Course Schedule
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean hasCircle = false;
    boolean[] onPath;
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCircle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }

    private void traverse(List<Integer>[] graph, int start) {
        if (hasCircle) {
            return;
        }

        if (onPath[start]) {
            hasCircle = true;
            return;
        }

        if (visited[start]) {
            return;
        }

        visited[start] = true;

        onPath[start] = true;
        for (int to : graph[start]) {
            traverse(graph, to);
        }
        onPath[start] = false;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */
