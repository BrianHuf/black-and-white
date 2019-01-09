import React from "react";

import "./TicTacToe.css";

class TicTacToe extends React.Component {
  CONFIG_CELL = {
    X: <i className="huge circle icon" />,
    O: <i className="huge circle outline icon" />,
    _: <div />,
    s: <i className="huge bolt icon" />
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
    console.log("CP1 " + event + " " + index);
    if (index === -1) {
      return;
    }

    if (index === this.state.selected) {
      index = null;
    }
    this.setState({ selected: index });
  }

  render() {
    const cells = [...this.props.board].map((value, index) =>
      this.getCell(value, index)
    );
    return <div className="tic-tac-toe">{cells}</div>;
  }
}

export default TicTacToe;
