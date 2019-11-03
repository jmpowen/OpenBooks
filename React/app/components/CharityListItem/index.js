import React from 'react';
import { ListItem, ListItemText} from '@material-ui/core/';
import { Link } from 'react-router-dom';

export default function CharityListItem(props) {
  const { charity_name, charity_Category, charity_id } = props;
  return (
    <ListItem component={Link} to={`/charity/${charity_id}`}>
      <ListItemText primary={charity_name} secondary={`${charity_name} - ${charity_Category}`} />
    </ListItem>
  );
}
