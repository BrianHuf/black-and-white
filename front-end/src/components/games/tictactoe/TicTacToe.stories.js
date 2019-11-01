import React from 'react';
import { storiesOf } from '@storybook/react';

import { TicTacToe } from './TicTacToe.js';
import '../App.css'


storiesOf('TicTacToe', module)
    .add('default', () => 
        <TicTacToe
            board="_XO______"
            nextPlayer="X"
            availableMoves={[0, 3, 4, 5]}
            selected="1"
            status="IN_PROGRESS" 
        />
    )

