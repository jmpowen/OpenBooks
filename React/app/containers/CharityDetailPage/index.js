/*
 * CharityDetailPage
 *
 */

import React from 'react';
import Container from '@material-ui/core';
import clsx from 'clsx';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Fab from '@material-ui/core/Fab';
import NavigationBar from '../../components/NavigationBar/Loadable';
import ImageSlider from '../../components/ImageSlider/Loadable';
import DonationList from '../../components/DonationList/Loadable';

const useStyles = makeStyles(theme => ({
  contentShift: {
    transition: theme.transitions.create('margin', {
        easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    margin: 0,
  },
  drawerHeader: {
      display: 'flex',
    alignItems: 'center',
      padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar,
    justifyContent: 'flex-end',
  },
  fab: {
    margin: theme.spacing(1),
  },
}))

export default function CharityDetailPage() {

  const name = "Shoes for Poor Kids Initiative LLC"; // TODO: Make this not hard coded.
  const description = "Shoes for Poor Kids Initiative LLC (SPKILLC) is a non-profit organization sa d;fha sjkdfasdlansdabsndmnbabsjh xnb,a,sjndfasd fasdfajnsdljha,sndbacmsndfalsdb kjhsd jfa sdf as d fanus ajshdkfjak  dogs. #Shoes4PoorKids";

  const classes = useStyles();
  const theme = useTheme();

  return (
    <div className={classes.root}>
      <NavigationBar id={'234'} isDonor={false} />
      <main
        className={clsx(classes.content, {
          [classes.contentShift]: open,
        })}
      >
        <div className={classes.drawerHeader} />
        <ImageSlider imageUrl={ require("../../images/icon-512x512.png") } />
        <div>
          <div float="left">
            <h1>{name}</h1>
            <Typography paragraph>
              {description}
            </Typography>
          </div>
          <div float="left">
            <Fab aria-label="donate" className={classes.fab}>DONATE</Fab>
            <h1>Recent Donations</h1>
            <DonationList />
          </div>
        </div>
      </main>
    </div>
  );
}
