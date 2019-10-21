import React from "react";
import SplitPane from "react-split-pane"

import TicTacToe from "./TicTacToe"
import TicTacToeMain from "./TicTacToeMain"
import "./SplitPane.css"

class TicTacToeLayout extends React.Component {
  render() {
    return (
      <SplitPane split="vertical" defaultSize="40vh" primary="second">
        <div className="tic-tac-toe-play ">
          <TicTacToeMain/>
        </div>
        <div className="tic-tac-toe-mcts centered">
            <div>
                <TicTacToe
                  board="_XO______"
                  nextPlayer="X"
                  availableMoves={[]}
                  selected="1"
                  status="&lt;&lt;&lt; Player 1 56% &gt;&gt;&gt; " 
                />
            </div>
        </div>
      </SplitPane>
    );
  }
}

export default TicTacToeLayout
