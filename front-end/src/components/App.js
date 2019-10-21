import React from "react";
import { Router, Route, Link } from "react-router-dom";

import history from "../history";
import TicTacToeLayout from "./games/TicTacToeLayout";
import Welcome from "./Welcome";
import "./App.css";

const App = () => {
  return (
    <Router history={history}>
      <div>
        <Link to="/">
          <h2>Home</h2>
        </Link>
        <div className="App">
          <div className="game-select">
            <Route exact path="/" component={Welcome} />
          </div>
          <Route
            exact
            path="/game/tictactoe/:playedMoves"
            component={TicTacToeLayout}
          />
        </div>
      </div>
    </Router>
  );
};

export default App;
