import React from "react";

import imagePlayer1 from "./images/p1.svg"
import imagePlayer2 from "./images/p2.svg"
import imageSelectable from "./images/selectable.svg"
import imageSelected from "./images/selected.svg"
import "./TicTacToe.css";


export default class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <image xlinkHref={imagePlayer1} />,
    O: <image xlinkHref={imagePlayer2} />,
    m: <image xlinkHref={imageSelectable} />,
    s: <image xlinkHref={imageSelected} />,
    _: <div />
  };

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

    let images = []
    if (value !== "_") {
      images.push(this.CONFIG_CELL[value])
    }

    let clickIndex = index;
    if (index === this.props.selected) {
      console.error("XXX")
      images.push(this.CONFIG_CELL["s"])
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
      <svg viewBox="0 0 500 500">
        {images}
      </svg>
        
      </div>
    );
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
        <div className="tic-tac-toe-board square">
          {cells}
        </div>
        <div className="tic-tac-toe-message">
          <p>{this.getPrompt()}</p>
        </div>
      </div>
    );
  }

  onClickCell(event, index) {
    // to override
  }
}
