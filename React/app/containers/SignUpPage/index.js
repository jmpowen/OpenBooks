/**
 *
 * SignUpPage
 *
 */

import React, { memo } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';
import { makeStyles } from '@material-ui/core/styles';

import NavigationBar from '../../components/NavigationBar/Loadable';
import { useInjectSaga } from 'utils/injectSaga';
import { useInjectReducer } from 'utils/injectReducer';
import makeSelectSignUpPage from './selectors';
import reducer from './reducer';
import saga from './saga';
import {
  changeRememberMe,
  changePassword2,
  changePassword,
  changeEmail,
  submitSignup
} from './actions';

const useStyles = makeStyles({
  root: {
    display: 'flex',
    alignItems: 'center',
    padding: '100px',
    justifyContent: 'flex',
  },
});

function SignUpPage(props) {
  useInjectReducer({ key: 'signUpPage', reducer });
  useInjectSaga({ key: 'signUpPage', saga });

  const { email, password, password2, save } = props;
  const classes = useStyles();

  return (
    <div>
      <div>
        <NavigationBar />
      </div>
      <div className={classes.root}>
        <form onSubmit={event => {
            event.preventDefault();
            props.handleSubmit(); }
          }
            >
          <label htmlFor="email">Email</label>
          <br />
          <input
            name="email"
            type="text"
            placeholder="Enter your email"
            value={email}
            onChange={props.handleEmail(event)}
          />
          <br />
          <label htmlFor="email">Password</label>
          <br />
          <input
            name="password"
            type="password"
            placeholder="Enter your password"
            value={password}
            onChange={props.handlePassword(event)}
          />
          <br />
          <input
            name="password2"
            type="password"
            placeholder="Enter your password again"
            value={password2}
            onChange={props.handlePassword2(event)}
          />
          <br />
          <label htmlFor="remember">Remember me </label>
          <input
            name="Remember me"
            type="checkbox"
            onClick={props.handleCheckbox(event)}
          />
          <br />
          <button type="submit">Login</button>
        </form>
      </div>
    </div>
  );
}


SignUpPage.propTypes = {
  dispatch: PropTypes.func.isRequired,
};

const mapStateToProps = createStructuredSelector({
  signUpPage: makeSelectSignUpPage(),
});

const mapDispatchToProps = dispatch => {
  return {
    handleSubmit: () => () => {
      dispatch(submitSignup())
    },
    handleEmail: event => ()=> dispatch(changeEmail(event.target.value)),
    handlePassword: event => () => dispatch(changePassword(event.target.value)),
    handlePassword2: event  => () => dispatch(changePassword2(event.target.value)),
    handleCheckbox: event => () => dispatch(changeRememberMe(event.target.value)),
    dispatch,
  };
}

const withConnect = connect(
  mapStateToProps,
  mapDispatchToProps,
);

export default compose(
  withConnect,
  memo,
)(SignUpPage);
