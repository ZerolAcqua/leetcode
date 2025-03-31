/*
 * @lc app=leetcode id=210 lang=java
 * @lcpr version=30103
 *
 * [210] Course Schedule II
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class Solution {

    boolean[] onPath;
    boolean[] visited;
    boolean hasCircle = false;
    List<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        postOrder = new ArrayList<>();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCircle) {
            return new int[0];
        } else {
            Collections.reverse(postOrder);
            return postOrder.stream().mapToInt(Integer::valueOf).toArray();
        }
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
        if (onPath[start]) {
            hasCircle = true;
        }

        if (hasCircle || visited[start]) {
            return;
        }

        visited[start] = true;
        onPath[start] = true;
        for (int to : graph[start]) {
            traverse(graph, to);
        }
        postOrder.add(start);
        onPath[start] = false;
    }

}
// @lc code=end

/*
 // @lcpr case=start
 // 2\n[[1,0]]\n
 // @lcpr case=end
 
 // @lcpr case=start
 // 4\n[[1,0],[2,0],[3,1],[3,2]]\n
 // @lcpr case=end
 
 // @lcpr case=start
 // 1\n[]\n
 // @lcpr case=end
 
 */
