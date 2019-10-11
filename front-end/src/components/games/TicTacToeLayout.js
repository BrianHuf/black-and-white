import React from "react";
import SplitPane from "react-split-pane"

import TicTacToe from "./TicTacToe"
import TicTacToeMain from "./TicTacToeMain"
import "./SplitPane.css"

class TicTacToeLayout extends React.Component {
  render() {
    return (
      <SplitPane split="vertical" defaultSize="40vh" primary="second">
        <div className="center-container-1">
          <div className="center-container-2 tic-tac-toe-play">
            <TicTacToeMain/>
          </div>
        </div>
        <div className="center-container-1">
          <div className="tic-tac-toe-mcts center-container-2">
              <TicTacToe
                  board="_XO______"
                  nextPlayer="X"
                  availableMoves={[0, 3, 4, 5]}
                  selected="1"
                  status="IN_PROGRESS" 
              />
              <TicTacToe
                  board="_XO_X____"
                  nextPlayer="X"
                  availableMoves={[0, 3, 5]}
                  selected="1"
                  status="IN_PROGRESS" 
              />
              <TicTacToe
                  board="_XO______"
                  nextPlayer="X"
                  availableMoves={[0, 3, 4, 5]}
                  selected="1"
                  status="IN_PROGRESS" 
              />
              <TicTacToe
                  board="_XO______"
                  nextPlayer="X"
                  availableMoves={[0, 3, 4, 5]}
                  selected="1"
                  status="IN_PROGRESS" 
              />
          </div>
        </div>
      </SplitPane>
    );
  }
}

export default TicTacToeLayout
