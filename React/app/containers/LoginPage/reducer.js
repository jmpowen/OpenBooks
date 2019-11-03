/*
 *
 * LoginForm reducer
 *
 */
import produce from 'immer';
import { LOGIN_ERROR, LOGIN_SUCCESSFUL, CHANGE_EMAIL, CHANGE_PASSWORD, CHANGE_PASSWORD_, TOGGLE_SAVE } from './constants';
//import { loginError, changeEmail, changePassword, changePassword2, toggleSave } from './actions';

export const initialState = {
  email: "",
  password: "",
  password2: "",
  save: false,
  error: "",
  verified: false
};

/* eslint-disable default-case, no-param-reassign */
const loginFormReducer = (state = initialState, action) =>
  produce(state, (draftState, action) => {
    switch (action.type) {
      case LOGIN_ERROR:
        draftState.error = action.error;
        break;
      case LOGIN_SUCCESSFUL:
        draftState.verified = action.verified;
        break;
      case CHANGE_EMAIL:
        draftState.email = action.email;
        break;
      case CHANGE_PASSWORD:
        draftState.password = action.password;
        break;
      case CHANGE_PASSWORD_:
        draftState.password2 = action.password2;
        break;
      case TOGGLE_SAVE:
        draftState.save = action.save;
        break;
    }
  });

export default loginFormReducer;
