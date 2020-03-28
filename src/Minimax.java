import java.util.List;

public class Minimax implements ISolver {
    @Override
    public String getSolverName() {
        return "Minimax";
    }

    @Override
    public double solve(IBoard board) {
        Node root = new Node(board, Node.NodeType.MAX);
        return MinimaxAlgorithm(root);
    }


    private double MinimaxAlgorithm(Node node) {
// Artificial intelligence function
        double toReturn=0;

        if (node.isTerminalNode()) {
            return node.getScore();
        }

        if (node.getNodeType().compareTo(Node.NodeType.MAX) == 0) {
            double maxEval = Double.MAX_VALUE*(-1);
            List<Node> children = node.getNodeChildren();
            for (int i = 0; i < children.size(); i++) {
                toReturn= MinimaxAlgorithm(children.get(i));
                maxEval = Math.max(toReturn, maxEval);
            }
            return maxEval;
        } else {
            double minEval = Double.MAX_VALUE;
            List<Node> children = node.getNodeChildren();
            for (int i = 0; i < children.size(); i++) {
                toReturn = MinimaxAlgorithm(children.get(i));
                minEval = Math.min(toReturn, minEval);
            }
            return minEval;
        }

    }
}
