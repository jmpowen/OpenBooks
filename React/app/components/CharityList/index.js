/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */
import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import CharityListItem from '../CharityListItem/Loadable';

const styles = {
  root: {
    width: '100%',
    maxWidth: 360,
    maxHeight: 200,
    overflow: 'auto',
  },
};

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

class CharityList extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const { classes } = this.props;
    return (
      <div className={classes.root}>
        <List component="ul">
          {data.map((list) => {
            return CharityListItem(list);
          })}
        </List>
      </div>
    );
  }
}

export default withStyles(styles)(CharityList);
