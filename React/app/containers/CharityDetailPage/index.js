/*
 * CharityDetailPage
 *
 */

import React from 'react';
import axios from 'axios';
import Container from '@material-ui/core';
import clsx from 'clsx';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Fab from '@material-ui/core/Fab';
import NavigationBar from '../../components/NavigationBar/Loadable';
import ImageSlider from '../../components/ImageSlider/Loadable';
import DonationList from '../../components/DonationList/Loadable';

const styles = {
  drawerHeader: {
      display: 'flex',
    alignItems: 'center',
      padding: 100,
    justifyContent: 'flex-end',
  },
  fab: {
    margin: 100,
  },
}

class CharityDetailPage extends React.Component {

  state = {
    charity_id: null,
    charity_name: null,
    charity_nickname: null,
    charity_description: null,
    charity_trending_rank: null,
    charity_Category: null,
    charity_links: null,
    charity_balance: null,
  }

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    console.log(id);
    axios.get(`http://10.27.165.202:8080/api/charity/${id}`)
      .then(res => {
        const charity = res.data;
        this.setState(charity);
      });
  }

  render() {
    const { classes } = this.props;
    return (
      <div className={classes.root}>
        <NavigationBar />
        <main
          className={clsx(classes.content, {
            [classes.contentShift]: open,
          })}
        >
          <div className={classes.drawerHeader} />
          <ImageSlider imageUrl={ require("../../images/icon-512x512.png") } />
          <div>
            <div float="left">
              <h1>{this.state.charity_name + " " + this.state.charity_id} </h1>
              <Typography paragraph>
                {this.state.charity_description}
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
}

export default withStyles(styles)(CharityDetailPage);
