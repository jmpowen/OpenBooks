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

function ListItemLink(props) {
  const { name, amount, comment } = props;
  return (
    <ListItem>
      <ListItemText primary={name + " $" + amount} secondary={comment} />
    </ListItem>
  );
}

export default function DonationList() {
  const classes = useStyles();

  const data = [
    {
      name: "Doug",
      amount: 500,
      comment: "Help the kiddos!",
    },
    {
      name: "Gary",
      amount: 4.20,
      comment: "I love children.",
    },
    {
      name: "John Johnson & Son",
      amount: 69,
      comment: "8=>",
    },
    {
      name: "Please kill me",
      amount: 1,
      comment: "There's no point.",
    },
  ];

  return (
    <div className={classes.root}>
      <List component="ul">
        {data.map((list) => {
          return ListItemLink(list);
        })}
      </List>
    </div>
  );
}
