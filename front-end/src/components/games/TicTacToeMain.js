import { withRouter } from "react-router-dom";
import { connect } from "react-redux";
import { fetchGameState, selectMove } from "../../actions";

import TicTacToe from "./TicTacToe"

class TicTacToeMain extends TicTacToe {
  componentDidMount() {
    this.props.fetchGameState("tictactoe", this.getPlayedMoves());
  }

  onClickCell(event, index) {
    if (index < 0) {
      return;
    }

    if (index === this.props.selected) {
      const newMoves = this.getPlayedMoves() + index;
      const nextUrl = "/game/tictactoe/" + newMoves;
      this.props.history.push(nextUrl);
      this.props.fetchGameState("tictactoe", newMoves);
    } else {
      this.props.selectMove(index)
    }
  }

  getPrompt() {
    switch (this.props.status) {
      case "IN_PROGRESS":
        return this.getPlayer();
      case "TIE":
        return "Tie Game";
      default:
        return this.getPlayer() + " Wins";
    }
  }
}

const mapStateToProps = state => {
  console.log("mapStateToProps", state.game);

  return {
    availableMoves: state.game.availableMoves,
    board: state.game.gameState,
    nextPlayer: state.game.nextPlayer,
    selected: state.game.selected,
    status: state.game.status
  };
};

export default withRouter(
  connect(
    mapStateToProps,
    { fetchGameState, selectMove }
  )(TicTacToeMain)
);
