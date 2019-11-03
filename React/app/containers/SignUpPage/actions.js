/*
 *
 * SignUpPage actions
 *
 */

import {
  SUBMIT_SIGNUP,
  SIGNUP_ERROR,
  SIGNUP_SUCCESSFUL,
  CHANGE_EMAIL,
  CHANGE_PASSWORD,
  CHANGE_PASSWORD_,
  CHANGE_REMEMBER_ME
} from './constants';

export function changeRememberMe({ save }) {
  console.log("remember:" + save.toString());
  return {
    type: CHANGE_REMEMBER_ME,
    save
  };
}

export function changePassword2({ password2 }) {
  console.log("pw2:" + password2);
  return {
    type: CHANGE_PASSWORD_,
    password2
  };
}

export function changePassword({ password }) {
  console.log("pw:" + password);
  return {
    type: CHANGE_PASSWORD,
    password
  };
}

export function changeEmail({ email }) {
  console.log("em:" + email);
  return {
    type: CHANGE_EMAIL,
    email
  };
}

export function signupSuccessful({ isValid }) {
  console.log("remember:" + isValid.toString());
  return {
    type: SIGNUP_SUCCESSFUL,
    isValid
  };
}

export function signupError({ error }) {
  console.log("err:" + error);
  return {
    type: SIGNUP_ERROR,
    error
  };
}

export function submitSignup() {
  console.log("submit");
  return {
    type: SUBMIT_SIGNUP,
  };
}
