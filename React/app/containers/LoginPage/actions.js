/*
 *
 * LoginForm actions
 *
 */

import { SUBMIT_CREDENTIALS, VERIFIED_CREDENTIALS, LOGIN_ERROR, CHANGE_EMAIL, CHANGE_PASSWORD, CHANGE_PASSWORD_, TOGGLE_SAVE } from './constants';

export function submitCredentials({ email, password, save }) {
  return {
    type: SUBMIT_CREDENTIALS,
    email,
    password,
    save
  };
}

export function verifiedCredentials({ verified }) {
  return {
    type: VERIFIED_CREDENTIALS,
    verified
  }
}

export function loginError({ error }) {
  return {
    type: SUBMIT_CREDENTIALS,
    error
  };
}

export function changeEmail({ email }) {
  return {
    type: CHANGE_EMAIL,
    email
  };
}

export function changePassword({ password }) {
  return {
    type: CHANGE_PASSWORD,
    password
  };
}

export function changePassword2({ password2 }) {
  return {
    type: CHANGE_PASSWORD_,
    password2
  };
}

export function toggleSave({ save }) {
  return {
    type: TOGGLE_SAVE,
    save
  };
}
