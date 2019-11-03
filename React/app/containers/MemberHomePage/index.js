/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import NavigationBar from '../../components/NavigationBar/Loadable';

export default function MemberHomePage() {
  return (
    <div>
      <NavigationBar />
      <div>
        MemberHomePage
      </div>
    </div>
  );
}
