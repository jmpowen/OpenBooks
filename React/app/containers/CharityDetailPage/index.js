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
import { LineChart, PieChart } from 'react-chartkick'
import 'chart.js'
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

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
    charity: null,
    donations: [],
    expenses: [],
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
    axios.get(`http://10.27.165.202:8080/api/donation/filter/charity/${id}`)
      .then(res => {
        const data = res.data;
        this.setState({ donations: data.content });
      });
    axios.get(`http://10.27.165.202:8080/api/expense/charity/${id}`)
      .then(res => {
        const data = res.data;
        this.setState({ expenses: data });
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
            <h1>{this.state.charity_name + " " + this.state.charity_id} </h1>
            <Typography paragraph>
              {this.state.charity_description}
            </Typography>
            <Fab aria-label="donate" className={classes.fab}>DONATE</Fab>
            <h1>Recent Donations</h1>
            <DonationList donations={this.state.donations} />
            <h1>Expenses</h1>
            <List>
              {this.state.expenses.map((expense) =>
                <ListItem>
                  <ListItemText primary={`${expense.expense_title} - $${expense.expense_amount}`} secondary={expense.expense_description} />
                </ListItem>)}
            </List>
            {this.state.expenses && <PieChart data={this.state.expenses.map((expense) => [expense.expense_title, expense.expense_amount])} />}
          </div>
        </main>
      </div>
    );
  }
}

export default withStyles(styles)(CharityDetailPage);
