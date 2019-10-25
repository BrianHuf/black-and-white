import { FETCH_GAME_STATE, FETCH_MOVES_TREE, SELECT_MOVE } from "../actions/types";

const INTIAL_STATE = {
  state: null,
  selected: null,
  movesTree: null,
};

export default (state = INTIAL_STATE, action) => {
  switch (action.type) {
    case FETCH_GAME_STATE:
      console.log("fetch game state", action.payload);
      return {
        ...state,
        gameState: action.payload.state,
        availableMoves: action.payload.availableMoves,
        nextPlayer: action.payload.nextPlayer,
        selected: null,
        status: action.payload.status
      };
    case FETCH_MOVES_TREE:
      console.log("fetch moves tree", action.payload);
      return {
        ...state,
        movesTree: action.payload 
      };
    case SELECT_MOVE:
      return {
        ...state,
        selected: action.payload
      };
    default:
      return state;
  }
};
