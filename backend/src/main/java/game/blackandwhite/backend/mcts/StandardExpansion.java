package game.blackandwhite.backend.mcts;

import static game.blackandwhite.backend.mcts.RandomSelector.randomSelect;

class StandardExpansion implements Expander {
    @Override
    public MctsNode expand(MctsNode selected) {
        if (selected.getVisits() == 0 || selected.getMove().getStatus().isGameOver()) {
            return selected;
        }

        selected.expand();
        return randomSelect(selected.getMctsChildren());
    }
}
