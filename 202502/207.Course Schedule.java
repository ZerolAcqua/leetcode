/*
 * @lc app=leetcode id=207 lang=java
 * @lcpr version=20004
 *
 * [207] Course Schedule
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    boolean[] inPath;
    boolean[] visited;
    boolean hasCircle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        inPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            tranverse(graph, i);
        }

        return !hasCircle;
    }

    private void tranverse(List<Integer>[] graph, int node) {
        if (hasCircle || visited[node]) {
            return;
        }

        if (inPath[node]) {
            hasCircle = true;
            return;
        }
        inPath[node] = true;
        for (int n : graph[node]) {
            tranverse(graph, n);
        }
        inPath[node] = false;

        visited[node] = true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }

        return graph;
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
