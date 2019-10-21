import TicTacToe from "./TicTacToe"

class TicTacToeMsctsNode extends TicTacToe {
  // componentDidMount() {
  //   this.props.fetchGameMoveTree("tictactoe", this.getPlayedMoves());
  // }

  getPrompt() {
    return <h1>ABCDEF</h1>
  }
}

export default TicTacToeMctsNode;
