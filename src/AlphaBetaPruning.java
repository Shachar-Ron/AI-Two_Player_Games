import java.util.List;

public class AlphaBetaPruning implements ISolver {
    @Override
    public String getSolverName() {
        return "Alpha-Beta Pruning";
    }

    @Override
    public double solve(IBoard board) {
        Node root = new Node(board, Node.NodeType.MAX);
        return AlphaBetaPruningAlgorithm(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }


    private double AlphaBetaPruningAlgorithm(Node node, double p_alpha, double p_beta) {
        double toReturn=0;
        double maxEval=p_alpha;
        double minEval=p_beta;

        if (node.isTerminalNode()) {
            return node.getScore();
        }
        if (node.getNodeType().compareTo(Node.NodeType.MAX) == 0) {

            maxEval = -Double.MAX_VALUE;
            List<Node> children = node.getNodeChildren();
            for (int i = 0; i < children.size(); i++) {
                toReturn = AlphaBetaPruningAlgorithm(children.get(i),p_alpha,p_beta);
                maxEval = Math.max(toReturn, maxEval);
                p_alpha=Math.max(p_alpha, toReturn);
                if(p_beta<=p_alpha){
                    break;
                }
            }
            return maxEval;
        } else {

            minEval = Double.MAX_VALUE;
            List<Node> children = node.getNodeChildren();
            for (int i = 0; i < children.size(); i++) {
                toReturn = AlphaBetaPruningAlgorithm(children.get(i),p_alpha,p_beta);
                minEval = Math.min(toReturn, minEval);
                p_beta=Math.min(p_beta, toReturn);
                if(p_beta<=p_alpha){
                    break;
                }
            }
            return minEval;
        }

    }

}
