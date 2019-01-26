import { FETCH_GAME_STATE, SELECT_MOVE } from "../actions/types";

const INTIAL_STATE = {
  state: null,
  selected: null
};

export default (state = INTIAL_STATE, action) => {
  switch (action.type) {
    case FETCH_GAME_STATE:
      console.log("gameReducer", action.payload);
      return {
        ...state,
        gameState: action.payload.state,
        availableMoves: action.payload.availableMoves,
        nextPlayer: action.payload.nextPlayer,
        selected: null,
        status: action.payload.status
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
