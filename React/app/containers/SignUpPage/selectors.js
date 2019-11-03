import { createSelector } from 'reselect';
import { initialState } from './reducer';

/**
 * Direct selector to the signUpPage state domain
 */

const selectSignUpPageDomain = state => state.signUpPage || initialState;

/**
 * Other specific selectors
 */

 export const emailSelector = state => state.email;
 export const passwordSelector = state => state.password;
 export const password2Selector = state => state.password2;
 export const isValidSelector = state => state.isValid;
 export const errorSelector = state => state.error;
 export const saveSelector = state => state.save;

/**
 * Default selector used by SignUpPage
 */

const makeSelectSignUpPage = () =>
  createSelector(
    selectSignUpPageDomain,
    substate => substate,
  );

export default makeSelectSignUpPage;
export { selectSignUpPageDomain };
