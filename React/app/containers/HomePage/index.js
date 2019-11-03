/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import clsx from 'clsx';
import { withStyles } from '@material-ui/core/styles';
import NavigationBar from '../../components/NavigationBar/Loadable';
import ImageSlider from '../../components/ImageSlider/Loadable';
import CharityList from '../../components/CharityList/Loadable';

const styles = {
  drawerHeader: {
    display: 'flex',
    alignItems: 'left',
    padding: '100px',
    justifyContent: 'flex-start',
  },
};

class HomePage extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const { classes } = this.props;
    return (
      <div className={classes.root}>
        <NavigationBar id={'234'} isDonor={false} />
        <main
          className={clsx(classes.content, {
            [classes.contentShift]: open,
          })}
        >
          <div className={classes.drawerHeader} />
          <ImageSlider imageUrl={ require("../../images/handwashing.jpg") } label="Clarity in Charity."/>
          <h1>Trending Charities</h1>
          <CharityList />
        </main>
      </div>
    );
  }
}

export default withStyles(styles)(HomePage);
