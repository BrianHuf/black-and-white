import React from 'react';
import { BrowserRouter } from "react-router-dom";
import { storiesOf } from '@storybook/react';
import { action } from '@storybook/addon-actions';

import ProviderWrapper from '../Provider.js'
import store from '../../configureStore.js'

import { PureTicTacToe } from './TicTacToe.js';
import '../App.css'
import "./SplitPane.css"

export const ticTacToe = {
    id: '1',
    title: 'Test TicTacToe',
    state: 'TASK_INBOX',
    updatedAt: new Date(2018, 0, 1, 9, 0),
};

// availableMoves: state.game.availableMoves,
// board: state.game.gameState,
// nextPlayer: state.game.nextPlayer,
// selected: state.game.selected,
// status: state.game.status

const withProvider = (story) => (
    <ProviderWrapper store={store}>
        <div className="App">
            {story()}
        </div>
    </ProviderWrapper>
)

storiesOf('TicTacToe', module)
    .addDecorator(withProvider)
    .add('default', () => 
        <PureTicTacToe
            board="_XO______"
            nextPlayer="X"
            availableMoves={[0, 3, 4, 5]}
            selected="1"
            status="IN_PROGRESS" 
        />
    )

