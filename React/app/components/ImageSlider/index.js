import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';

const useStyles = makeStyles({
  card: {
    minWidth: 275,
  },
  media: {
    height: 500,
  },
});

export default function ImageSlider() {

  const imagePath = "../../images/icon-512x512.png";
  const imageTitle = "A cool icon";

  const classes = useStyles();

  return (
    <Card className={classes.card}>
      <CardContent>
        <CardMedia
          className={classes.media}
          image={require("../../images/icon-512x512.png")}
          title={imageTitle}
        />
      </CardContent>
    </Card>
  );
}
