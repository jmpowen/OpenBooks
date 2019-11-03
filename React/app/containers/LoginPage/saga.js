import { take, call, put, select, takeLatest } from 'redux-saga/effects';
import { SUBMIT_CREDENTIALS, LOGIN_ERROR, LOGIN_SUCCESSFUL } from './constants';
import { submitCredentials, loginError } from './actions';

function* fetchUser(action) {
  try {
    const user = yield call() //Need API here
    yield put(verifiedCredentials({ verified: true }));
  } catch(e) {
    yeild put(loginError({error: e.message}));
  }
}

// Individual exports for testing
export default function* loginFormSaga() {
  yield takeLatest(SUBMIT_CREDENTIALS, fetchUser);
}
