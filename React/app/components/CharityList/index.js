/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */
import React from 'react';
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

export default function CharityList(props) {
  const { charities } = props;
  return (
    <div className={styles.root}>
      <List component="ul">
        {charities.map((charity) => <CharityListItem {...charity} />)}
      </List>
    </div>
  );
}
