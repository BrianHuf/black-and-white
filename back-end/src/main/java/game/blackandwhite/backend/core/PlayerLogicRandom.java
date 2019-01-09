package game.blackandwhite.backend.core;

import static game.blackandwhite.backend.core.RandomSelector.randomSelect;

public class PlayerLogicRandom implements PlayerLogic {
    public Move select(State state) {
        return randomSelect(state.getAvailableMoves());
    }
}
