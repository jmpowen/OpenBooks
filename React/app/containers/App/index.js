/**
 *
 * App.js
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 *
 */

import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from 'containers/HomePage/Loadable';
import LoginPage from 'containers/LoginPage/Loadable';
import SignUpPage from 'containers/SignUpPage/Loadable';
import DonorHomePage from 'containers/DonorHomePage/Loadable';
import MemberHomePage from 'containers/MemberHomePage/Loadable';
import AccountPage from 'containers/AccountPage/Loadable';
import NotFoundPage from 'containers/NotFoundPage/Loadable';
import CharityDetailPage from 'containers/CharityDetailPage/Loadable';

import GlobalStyle from '../../global-styles';

export default function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={HomePage} />
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/signup" component={SignUpPage} />
        <Route path="/donors/:id" component={DonorHomePage} />
        <Route path="/volunteers/:id" component={MemberHomePage} />
        <Route path="/account/:id" component={AccountPage} />
        <Route path="/charity/:id" component={CharityDetailPage} />
        <Route component={NotFoundPage} />
      </Switch>
      <GlobalStyle />
    </div>
  );
}
