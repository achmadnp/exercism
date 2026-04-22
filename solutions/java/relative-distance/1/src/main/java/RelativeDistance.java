import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class RelativeDistance {

    private final Map<String, List<String>> graph;

    RelativeDistance(Map<String, List<String>> familyTree) {
        this.graph = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            graph.putIfAbsent(parent, new ArrayList<>());

            for (String child : children) {
                graph.putIfAbsent(child, new ArrayList<>());
                graph.get(parent).add(child);
                graph.get(child).add(parent);
            }

            for (int i = 0; i < children.size(); i++) {
                for (int j = i + 1; j < children.size(); j++) {
                    String c1 = children.get(i);
                    String c2 = children.get(j);
                    graph.get(c1).add(c2);
                    graph.get(c2).add(c1);
                }
            }
        }
    }

    int degreeOfSeparation(String personA, String personB) {
        if (!graph.containsKey(personA) || !graph.containsKey(personB)) {
            return -1;
        }

        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(personA);
        visited.put(personA, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int dist = visited.get(current);

            for (String neighbor : graph.get(current)) {
                if (neighbor.equals(personB)) {
                    return dist + 1;
                }
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, dist + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}
