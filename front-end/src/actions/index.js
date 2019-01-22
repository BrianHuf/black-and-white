import backend from "../apis/backend.js";

import { FETCH_GAME_STATE, SELECT_MOVE } from "./types.js";

export const fetchGameState = (gameType, gameMoves) => async dispatch => {
  console.log("action/fetchGameState request", gameType, gameMoves);
  const response = await backend.get("movesToState", {
    params: {
      game: gameType,
      moves: gameMoves
    }
  });

  dispatch({ type: FETCH_GAME_STATE, payload: response.data });
};

export const selectMove = move => (dispatch, state) => {
  dispatch({ type: SELECT_MOVE, payload: move });
};
