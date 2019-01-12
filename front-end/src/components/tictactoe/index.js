import React from "react";

import "./TicTacToe.css";

class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <svg viewBox="0 0 500 500"><image xlinkHref="/images/p1.svg"/></svg>,
    O: <svg viewBox="0 0 500 500"><image xlinkHref="/images/p2.svg"/></svg>,
    _: <svg viewBox="0 0 500 500"><image xlinkHref="/images/selectable.svg"/></svg>,
    s: <svg viewBox="0 0 500 500"><image xlinkHref="/images/selected.svg"/></svg>,
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
        {this.CONFIG_CELL[value]}
      </div>
    );
  }

  onClickCell(event, index) {
    if (index === -1) {
    }

    if (index === this.state.selected) {
      index = null;
    }

    this.setState({ selected: index });
  }

  getBoardFromUrl() {
    let fullPath = this.props.location.pathname;
    let rootPath = this.props.match.path;
    let extraPath = fullPath.substring(rootPath.length + 1, fullPath.length);
    return extraPath;
  }

  render() {    
    let board = this.props.board ||this.getBoardFromUrl();
    const cells = [...board].map((value, index) =>
      this.getCell(value, index)
    );
    return <div className="tic-tac-toe square">{cells}</div>;
  }
}

export default TicTacToe;
