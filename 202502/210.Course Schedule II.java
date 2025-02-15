/*
 * @lc app=leetcode id=210 lang=java
 * @lcpr version=20004
 *
 * [210] Course Schedule II
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    boolean[] inPath;
    boolean[] visited;
    boolean hasCircle;
    List<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        postOrder = new LinkedList<>();

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (hasCircle) {
                return new int[0];
            }
            tranverse(graph, i);
        }

        Collections.reverse(postOrder);
        int[] res = new int[numCourses];

        int idx = 0;
        for (int node : postOrder) {
            res[idx] = node;
            idx++;
        }

        return res;

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

        postOrder.add(node);
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
// 4\n[[1,0],[2,0],[3,1],[3,2]]\n
// @lcpr case=end

// @lcpr case=start
// 1\n[]\n
// @lcpr case=end

 */
