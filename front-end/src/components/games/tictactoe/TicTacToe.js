import React from "react";

import imagePlayer1 from "../images/p1.svg"
import imagePlayer2 from "../images/p2.svg"
import imageSelectable from "../images/selectable.svg"
import imageSelected from "../images/selected.svg"
import "./TicTacToe.css";


export default class TicTacToe extends React.Component {
  getPlayedMoves() {
    const played = this.props.match.params.playedMoves;
    return played !== ":new" ? played : "";
  }

  getPrompt() {
    return this.props.status;
  }

  getPlayer() {
    return this.props.nextPlayer;
  }

  renderCell(value, index) {
    let x = Math.floor(index / 3);
    let y = index % 3;

    let images = []

    if (value !== "_") {
      images.push(this.getImage(value, images))
    }

    let clickIndex = index;
    if (index === this.props.selected) {
      images.push(this.getImage("s", index))
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

  getImage(value, index) {
    switch (value) {
      case 'X': return <image key={index} xlinkHref={imagePlayer1} />;
      case 'O': return <image key={index} xlinkHref={imagePlayer2} />;
      case 'm': return <image key={index} xlinkHref={imageSelectable} />;
      case 's': return <image key={index} xlinkHref={imageSelected} />;
      default: return <div key={index} />
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
        <div className="tic-tac-toe-board square">
          {cells}
        </div>
        <div className="tic-tac-toe-message">
          {this.getPrompt()}
        </div>
      </div>
    );
  }

  onClickCell(event, index) {
    // to override
  }
}
