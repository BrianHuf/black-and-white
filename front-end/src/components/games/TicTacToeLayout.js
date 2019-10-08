import React from "react";
import SplitPane from "react-split-pane"

import TicTacToe from "./TicTacToe.js"
import "./SplitPane.css"

class TicTacToeLayout extends React.Component {
  render() {
    return (
      <SplitPane split="vertical" defaultSize="40vh" primary="second">
        <div>
          <TicTacToe/>
        </div>
        <div>
          <h1>D ght hand</h1>
        </div>
      </SplitPane>
      
    );
  }
}

export default TicTacToeLayout
