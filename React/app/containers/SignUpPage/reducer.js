/*
 *
 * SignUpPage reducer
 *
 */
import produce from 'immer';
import {
  SUBMIT_SIGNUP,
  SIGNUP_ERROR,
  SIGNUP_SUCCESSFUL,
  CHANGE_EMAIL,
  CHANGE_PASSWORD,
  CHANGE_PASSWORD_,
  CHANGE_REMEMBER_ME
} from './constants';

export const initialState = {
  email: '',
  password: '',
  password2: '',
  isValid: '',
  save: '',
  error: '',
};

/* eslint-disable default-case, no-param-reassign */
const signUpPageReducer = (state = initialState, action) =>
  produce(state, (action) => {
    switch (action.type) {
      case SIGNUP_ERROR:
        draftstate.error = action.error;
        break;
      case SIGNUP_SUCCESSFUL:
        draftstate.isValid = action.isValid;
        break;
      case CHANGE_EMAIL:
        draftstate.email = action.email;
        break;
      case CHANGE_PASSWORD:
        draftstate.password = action.password;
        break;
      case CHANGE_PASSWORD_:
        draftstate.password2 = action.password2;
        break;
      case CHANGE_REMEMBER_ME:
        draftstate.save = action.save;
        break;
    }
  });

export default signUpPageReducer;
