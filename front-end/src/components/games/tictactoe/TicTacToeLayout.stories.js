import React from 'react';
import { BrowserRouter } from "react-router-dom";
import { storiesOf } from '@storybook/react';
import { action } from '@storybook/addon-actions';

import ProviderWrapper from '../../Provider.js'
import store from '../../../configureStore.js'

import TicTacToeLayout from './TicTacToeLayout.js';

const withProvider = (story) => (
    <ProviderWrapper store={store}>
        <div>
            {story()}
        </div>
    </ProviderWrapper>
)

storiesOf('TicTacToeLayout', module)
    .addDecorator(withProvider)
    .add('default', () => 
        <TicTacToeLayout/>
    )
