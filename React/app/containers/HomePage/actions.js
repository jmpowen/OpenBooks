/*
 *
 * LoginForm actions
 *
 */

import { SUBMIT_CREDENTIALS } from './constants';

export function defaultAction() {
  return {
    type: SUBMIT_CREDENTIALS,
  };
}
