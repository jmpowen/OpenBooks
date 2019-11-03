import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CardHeader from '@material-ui/core/CardHeader';

const useStyles = makeStyles({
  card: {
    minWidth: 500,
  },
  media: {
    minHeight: 500,
  },
});

export default function ImageSlider(props) {

  const imagePath = "../../images/icon-512x512.png";
  const imageTitle = "A cool icon";

  const classes = useStyles();

  return (
    <Card className={classes.card}>
      <CardContent>
        <CardHeader title={props.label} />
        <CardMedia
          className={classes.media}
          image={props.imageUrl}
          title={props.imageTitle}
        />
      </CardContent>
    </Card>
  );
}
