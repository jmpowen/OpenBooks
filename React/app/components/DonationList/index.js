/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
// import DonationListItem from '../DonationListItem/Loadable';

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    maxWidth: 360,
    maxHeight: 200,
    backgroundColor: theme.palette.background.paper,
    overflow: 'auto',
  },
}));

function BindListItem(props) {
  const { donor_id, donation_amount, donation_comment } = props;
  return (
    <ListItem>
      <ListItemText primary={`${donor_id} - $${donation_amount}`} secondary={donation_comment} />
    </ListItem>
  );
}

export default function DonationList(props) {
  const classes = useStyles();
  const {donations} = props;
  return (
    <div className={classes.root}>
      <List component="ul">
        {donations.map((donation) => <BindListItem {...donation} />)}
      </List>
    </div>
  );
}
