import React from "react";
import { withRouter } from "react-router-dom";
import { connect } from "react-redux";
import { fetchGameState, selectMove } from "../../actions";

import "./TicTacToe.css";

class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <image xlinkHref="/images/p1.svg" />,
    O: <image xlinkHref="/images/p2.svg" />,
    _: <image xlinkHref="/images/selectable.svg" />,
    s: <image xlinkHref="/images/selected.svg" />
  };

  componentDidMount() {
    this.props.fetchGameState("tictactoe", this.getPlayedMoves());
  }

  getPlayedMoves() {
    const path = this.props.history.location.pathname;
    const playedMoves = path
      .replace("/tictactoe/", "")
      .replace("/tictactoe", "");
    console.log("palyed moves", playedMoves);
    return playedMoves;
  }

  getCell(value, index) {
    let x = Math.floor(index / 3);
    let y = index % 3;

    let clickIndex = index;
    if (index === this.props.selected) {
      value = "s";
    } else if (value !== "_") {
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
    if (index === this.props.selected) {
      const newMoves = this.getPlayedMoves() + index;
      const nextUrl = "/tictactoe/" + newMoves;
      this.props.history.push(nextUrl);
      this.props.fetchGameState("tictactoe", newMoves);
    } else {
      this.props.selectMove(index);
    }
  }

  render() {
    console.log("TicTacToe.js/render()", this.props);
    const board = this.props.board;
    if (board) {
      const cells = [...board].map((value, index) =>
        this.getCell(value, index)
      );
      return <div className="tic-tac-toe square">{cells}</div>;
    } else {
      return <div>Loading...</div>;
    }
  }
}

const mapStateToProps = state => {
  console.log("mapStateToProps", state.game);

  return {
    board: state.game.gameState,
    moves: state.game.moves,
    selected: state.game.selected
  };
};

export default withRouter(
  connect(
    mapStateToProps,
    { fetchGameState, selectMove }
  )(TicTacToe)
);
