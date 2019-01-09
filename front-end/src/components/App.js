import React from "react";

import TicTacToe from "./tictactoe/";
import "./App.css";

const App = () => {
  let board = "XO_XOX_XO";
  return (
    <div className="App">
      <div>Welcome!!</div>
      <div className="game">
        <TicTacToe board={board} />
      </div>
    </div>
  );
};

export default App;
