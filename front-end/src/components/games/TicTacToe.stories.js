import React from 'react';
import { BrowserRouter } from "react-router-dom";
import { storiesOf } from '@storybook/react';
import { action } from '@storybook/addon-actions';

import ProviderWrapper from '../Provider.js'
import store from '../../configureStore.js'

import { PureTicTacToe } from './TicTacToe.js';
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

