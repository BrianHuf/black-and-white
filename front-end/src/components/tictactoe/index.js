import React from "react";
import { withRouter } from "react-router-dom";

import "./TicTacToe.css";

class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <image xlinkHref="/images/p1.svg" />,
    O: <image xlinkHref="/images/p2.svg" />,
    _: <image xlinkHref="/images/selectable.svg" />,
    s: <image xlinkHref="/images/selected.svg" />
  };

  constructor(props) {
    super(props);
    this.state = {
      selected: null
    };
  }

  getCell(value, index) {
    let x = Math.floor(index / 3);
    let y = index % 3;

    let clickIndex = index;
    if (index === this.state.selected) {
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
    if (index === this.state.selected) {
      this.props.history.push(`/tictactoe/${this.getCurrentMoves()}${index}`);
      index = null;
    }

    this.setState({ selected: index });
  }

  getMovesFromUrl() {
    let fullPath = this.props.location.pathname;
    let rootPath = this.props.match.path;
    let extraPath = fullPath.substring(rootPath.length + 1, fullPath.length);
    return extraPath;
  }

  getBoardFromMoves(moves) {
    const board = Array(9).fill("_");
    [...moves].forEach((value, index) => {
      board[value] = index % 2 ? "O" : "X";
    });
    return board;
  }

  getCurrentMoves() {
    return this.props.moves || this.getMovesFromUrl() || "";
  }

  render() {
    const moves = this.getCurrentMoves();
    const board = this.getBoardFromMoves(moves);
    const cells = board.map((value, index) => this.getCell(value, index));
    return <div className="tic-tac-toe square">{cells}</div>;
  }
}

export default withRouter(TicTacToe);
