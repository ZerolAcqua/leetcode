/*
 * @lc app=leetcode id=886 lang=java
 * @lcpr version=30005
 *
 * [886] Possible Bipartition
 */


// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    boolean[] color;
    boolean[] visited;

    boolean isBipartite = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];

        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            traverse(graph, i);
        }

        return isBipartite;
    }

    List<Integer>[] buildGraph(int n, int[][] pairs) {
        List<Integer>[] graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] pair : pairs) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        return graph;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (!isBipartite) {
            return;
        }

        visited[s] = true;
        boolean curColor = color[s];
        for (int node : graph[s]) {
            if (visited[node]) {
                if (curColor == color[node]) {
                    isBipartite = false;
                    return;
                }
            } else {
                color[node] = !curColor;
                traverse(graph, node);
            }
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n[[1,2],[1,3],[2,4]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[[1,2],[1,3],[2,3]]\n
// @lcpr case=end

 */

