/*
 *
 * LoginForm reducer
 *
 */
import produce from 'immer';
import { SUBMIT_CREDENTIALS } from './constants';

export const initialState = {};

/* eslint-disable default-case, no-param-reassign */
const loginFormReducer = (state = initialState, action) =>
  produce(state, (/* draft */) => {
    switch (action.type) {
      case SUBMIT_CREDENTIALS:
        break;
    }
  });

export default loginFormReducer;
