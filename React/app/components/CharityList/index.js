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
  const { longName, category } = props;
  return (
    <ListItem>
      <ListItemText primary={longName} secondary={category} />
    </ListItem>
  );
}

export default function CharityList() {
  const classes = useStyles();

  const data = [
    {
      longName: "Saxophones for White Kids Association",
      category: "Uncategorized",
    },
    {
      longName: "Gary G Coleman Foundation",
      category: "Please don't.",
    },
    {
      longName: "Dogs for White Kids Association",
      category: "#SaveTheDogs",
    },
    {
      longName: "White Kids for Dogs Association",
      category: "Hungry.",
    },
    {
      longName: "Canned Parenthood",
      category: "#NotMyPresident",
    },
    {
      longName: "Saxophones for White Kids Association",
      category: "Feeding Hungry Kittens",
    },
  ];

  return (
    <div className={classes.root}>
      <List component="ul">
        {data.map((list) => {
          return BindListItem(list);
        })}
      </List>
    </div>
  );
}
