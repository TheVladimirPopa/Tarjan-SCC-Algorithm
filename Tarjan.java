import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.lang.Math.min;

public class Tarjan {
    public static int index = 0;
    public static Stack<Node<?>> stack = new Stack<>();

    public static List<List<Node<?>>> stronglyConnectedComponents(List<Node<?>> graph) {
        List<List<Node<?>>> stronglyConnectedComponentList = new LinkedList<>();

        for (Node<?> node : graph) {
            if (node.getIndex() == null) {
                strongConnect(node, stronglyConnectedComponentList);
            }
        }

        return stronglyConnectedComponentList;
    }

    /**
     * Performs a single dfs of the graph, finding all successors of the given node and returning all strongly
     * connected components of the resulting subgraph and adding them to the main list
     *
     * @param node the given node
     * @param stronglyConnectedComponentList the list of strongly connected components
     */

    private static void strongConnect(Node<?> node, List<List<Node<?>>> stronglyConnectedComponentList) {

        node.setIndex(index);
        node.setLowLink(index);

        index++;
        stack.push(node);

        for (Node<?> adjacent : node.getAdjacents()) {
            if (adjacent.getIndex() == null) {
                strongConnect(adjacent, stronglyConnectedComponentList);
                node.setLowLink(min(node.getLowLink(), adjacent.getLowLink()));
            } else if (stack.contains(adjacent)) {
                node.setLowLink(min(node.getLowLink(), adjacent.getIndex()));
            }
        }

        if (node.getLowLink().equals(node.getIndex())) {
            List<Node<?>> stronglyConnectedComponent = new LinkedList<>();
            Node<?> adjacent;

            do {
                adjacent = stack.pop();
                stronglyConnectedComponent.add(adjacent);
            } while (!node.equals(adjacent));

            stronglyConnectedComponentList.add(stronglyConnectedComponent);
        }
    }
}
