import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import TicTacToe from "./tictactoe/";
import "./App.css";

const App = () => {
  return (
    <Router>
      <div className="App">
        <div>Welcome!!</div>
        <Route path="/tictactoe" component={TicTacToe} />
      </div>
    </Router>
  );
};

export default App;
