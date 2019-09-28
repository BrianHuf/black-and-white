[![Build Status](https://travis-ci.org/simkimsia/UtilityBehaviors.png)](https://travis-ci.org/BrianHuf/black-and-white)
[![Coverage Status](https://coveralls.io/repos/github/BrianHuf/black-and-white/badge.svg?branch=master)](https://coveralls.io/github/BrianHuf/black-and-white?branch=master)


# Black and White

Abstract strategy board games. Emphasis is on playing against computer and learning how to play better

This is a side-project primarily for learning

## Status
- Back end - Multithreaded MCTS is working.  No AI yet
- Front end - Tic Toe Toe working.  Not connected to MCTS

## Next Steps
- Connect MCTS back end to Tic-Tac-Toe front end
- Provide visual representation of MCTS tree
- Create Siam game


## To Play
Shell #1
```bash
gradle startBackEnd
```

Shell #2
```bash
gradle npmInstall startFrontEnd
```

## Technology (planned)

- **Javacsript React** for front end
- **Java Spring** for back end
- Multi-threaded **MCTS** augmented with ML (probably **Deeplearning4j** or **Keras**)


## License

Apache 2.0
