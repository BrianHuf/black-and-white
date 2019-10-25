import React from "react";

import { withRouter } from "react-router-dom";
import { connect } from "react-redux";
import { fetchMovesTree } from "../../../actions";

import TicTacToe from "./TicTacToe"

class TicTacToeTree extends React.Component {
  componentDidMount() {
    this.props.fetchMovesTree("tictactoe", this.getPlayedMoves());
  }

  getPlayedMoves() {
    const played = this.props.match.params.playedMoves;
    return played !== ":new" ? played : "";
  }

  render() {
    if (this.props.movesTree === null) {
      return <h1>Loading...</h1>;
    }

    const moves = [];
    let currMove = this.props.movesTree;
    let level = 0;
    while(currMove.children.length) {
      currMove = currMove.children.sort((a,b) => { return b.goodness - a.goodness })[0];

      let goodnessStr = isNaN(currMove.goodness) ? 0 : currMove.goodness.toFixed(0)
      const text = (
        <div>
          <div>Goodness = {goodnessStr}</div>
          <div>Visits = {currMove.visits}</div>
        </div>
      );

      moves.push(
        <div key={level}>
          <TicTacToe
              board={currMove.move}
              nextPlayer="X"
              availableMoves=""
              selected="4"
              status={text}
          />  
        </div>
      );

      level++;
    }

    return (
      <div>
        {moves}
      </div>
    );
  }
}

const mapStateToProps = state => {
  console.log("mapStateToProps", state.game);

  return {
    board: state.game.gameState,
    nextPlayer: state.game.nextPlayer,
    status: state.game.status,
    movesTree: state.game.movesTree,
  };
};

export default withRouter(
  connect(
    mapStateToProps,
    { fetchMovesTree }
  )(TicTacToeTree)
);
