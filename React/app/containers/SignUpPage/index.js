/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import NavigationBar from '../../components/NavigationBar/Loadable';

export default function SignUpPage() {
  return (
    <div>
      <NavigationBar id={'234'} isDonor={false} />
      <div>
        SignUpPage
      </div>
    </div>
  );
}
