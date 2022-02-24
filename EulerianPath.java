package templates;

import java.util.*;

public class EulerianPath {
    Map<Integer, List<Integer>> graph;
    // If the outdegree - indegree of all the nodes are zero, pick one node randomly as cur to start dfs.
    // If only one node's outdegree - indegree is 1, and only one node's outdegree - indegree is 1,
    // pick the node whose outdegree - indegree = 1 as cur to start dfs.
    // else, no eulerian  path exists.
    void dfs(int cur, List<Integer> path) {
        List<Integer> neis = graph.getOrDefault(cur, new ArrayList<>());
        while (neis.size() > 0) {
            int nei = neis.get(neis.size() - 1);
            neis.remove(neis.size() - 1);
            dfs(nei, path);
        }
        path.add(cur);
    }
}
