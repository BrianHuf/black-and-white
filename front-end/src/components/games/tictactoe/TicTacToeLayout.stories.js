import React from 'react';
import { storiesOf } from '@storybook/react';

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
