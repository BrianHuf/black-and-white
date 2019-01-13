import React from "react";
import { Link } from "react-router-dom";

class Welcome extends React.Component {
  render() {
    return (
      <div>
        <div>Welcome</div>
        <p />
        <Link to="/tictactoe">Tic Tic Toe</Link>
      </div>
    );
  }
}

export default Welcome;
