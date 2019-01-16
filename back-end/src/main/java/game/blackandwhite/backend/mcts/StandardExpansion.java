package game.blackandwhite.backend.mcts;

import java.util.List;

import static game.blackandwhite.backend.core.RandomSelector.randomSelect;

class StandardExpansion implements Expander {
    @Override
    public Node expand(Node selected) {
        if (selected.getVisits() == 0 || selected.getMove().getStatus().isGameOver()) {
            return selected;
        }

        selected.expand();
        return randomSelect((List<Node>)selected.getChildren());
    }
}
