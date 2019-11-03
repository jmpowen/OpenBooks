import React from 'react';
import { ListItem, ListItemText} from '@material-ui/core/';

export default function CharityListItem(props) {
  const { longName, category } = props;
  return (
    <ListItem>
      <ListItemText primary={longName} secondary={category} />
    </ListItem>
  );
}
