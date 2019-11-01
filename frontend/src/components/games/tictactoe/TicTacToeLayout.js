import React from "react";
import SplitPane from "react-split-pane"

import TicTacToeMain from "./TicTacToeMain"
import TicTacToeTree from "./TicTacToeTree"
import "../SplitPane.css"

class TicTacToeLayout extends React.Component {
  render() {
    return (
      <SplitPane split="vertical" defaultSize="40vh" primary="second">
        <div className="tic-tac-toe-play ">
          <TicTacToeMain/>
        </div>
        <div className="tic-tac-toe-mcts centered">
            <TicTacToeTree/>
        </div>
      </SplitPane>
    );
  }
}

export default TicTacToeLayout
