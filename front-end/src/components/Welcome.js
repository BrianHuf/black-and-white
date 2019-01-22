import React from "react";
import { Link } from "react-router-dom";

class Welcome extends React.Component {
  render() {
    return (
      <div>
        <h1>Welcome</h1>
        <p />
        <Link to="/tictactoe">
          <h2>Tic Tic Toe</h2>
        </Link>
      </div>
    );
  }
}

export default Welcome;
