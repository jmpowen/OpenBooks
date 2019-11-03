/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import NavigationBar from '../../components/NavigationBar/Loadable';

class HomePage extends React.Component {

  render() {
    return (
      <div>
        <NavigationBar id={'234'} isDonor={false} />
        <div>
          Homepage
        </div>
      </div>
    );
  }
}

export default HomePage;
