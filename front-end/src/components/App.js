import React from "react";
import { Router, Route, Link } from "react-router-dom";

import history from "../history";
import TicTacToe from "./games/TicTacToe";
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
          <Route exact path="/" component={Welcome} />
          <Route path="/tictactoe" component={TicTacToe} />
        </div>
      </div>
    </Router>
  );
};

export default App;
