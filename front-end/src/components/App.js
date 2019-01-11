import React from "react";

import TicTacToe from "./tictactoe/";
import "./App.css";

const App = () => {
  return (
    <div className="App">
      <div>Welcome!!</div>
      <div className="game">
        <TicTacToe moves="048" />
      </div>
    </div>
  );
};

export default App;
