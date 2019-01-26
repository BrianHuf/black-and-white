import React from "react";
import { withRouter } from "react-router-dom";
import { connect } from "react-redux";
import { fetchGameState, selectMove } from "../../actions";

import "./TicTacToe.css";

class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <image xlinkHref="/images/p1.svg" />,
    O: <image xlinkHref="/images/p2.svg" />,
    m: <image xlinkHref="/images/selectable.svg" />,
    s: <image xlinkHref="/images/selected.svg" />,
    _: <div />
  };

  componentDidMount() {
    this.props.fetchGameState("tictactoe", this.getPlayedMoves());
  }

  getPlayedMoves() {
    const played = this.props.match.params.playedMoves;
    return played !== ":new" ? played : "";
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

  getPlayer() {
    switch (this.props.nextPlayer) {
      case "X":
        return "Player 1";
      case "O":
        return "Player 2";
      default:
        return "Nobody";
    }
  }

  renderCell(value, index) {
    let x = Math.floor(index / 3);
    let y = index % 3;

    let clickIndex = index;
    if (index === this.props.selected) {
      value = "s";
    } else if (value !== "m") {
      clickIndex = -1;
    }

    return (
      <div
        className="tic-tac-toe-cell"
        onClick={e => this.onClickCell(e, clickIndex)}
        cellx={x}
        celly={y}
        key={index}
      >
        <svg viewBox="0 0 500 500">{this.CONFIG_CELL[value]}</svg>
      </div>
    );
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
      this.props.selectMove(index);
    }
  }

  render() {
    const board = this.props.board;
    if (!board) {
      return <div>Loading...</div>;
    }

    let boardArray = [...board];
    if (this.props.availableMoves) {
      this.props.availableMoves.map(index => (boardArray[index] = "m"));
    }

    const cells = boardArray.map((value, index) =>
      this.renderCell(value, index)
    );

    return (
      <div className="tic-tac-toe">
        <div className="tic-tac-toe-board square">{cells}</div>
        <div>
          <h2 className="ui center aligned header">{this.getPrompt()}</h2>
        </div>
      </div>
    );
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
  )(TicTacToe)
);
