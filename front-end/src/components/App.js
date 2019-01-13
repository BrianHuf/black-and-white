import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

import TicTacToe from "./tictactoe/";
import Welcome from "./Welcome";
import "./App.css";

const App = () => {
  return (
    <Router>
      <div>
        <Link to="/">Home</Link>
        <div className="App">
          <Route exact path="/" component={Welcome} />
          <Route path="/tictactoe" component={TicTacToe} />
        </div>
      </div>
    </Router>
  );
};

export default App;
