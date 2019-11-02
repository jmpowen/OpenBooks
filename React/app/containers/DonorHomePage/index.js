/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import { useParams } from 'react-router-dom';
import NavigationBar from '../../components/NavigationBar/Loadable';

export default function DonorHomePage() {
  let { id } = useParams();
  return (
    <div>
      <NavigationBar id={'234'} isDonor={false} />
      <div>
        DonorHomePage {id}
      </div>
    </div>
  );
}
