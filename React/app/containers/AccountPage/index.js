/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import axios from 'axios';
import { withStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import NavigationBar from '../../components/NavigationBar/Loadable';

const styles = {
  drawerHeader: {
      display: 'flex',
    alignItems: 'center',
      padding: 100,
    justifyContent: 'flex-end',
  },
}

class AccountPage extends React.Component {

  state = {
    user_id: null,
    user_email: null,
    username: null,
    user_biography: null,
  }

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    // fetch("/user/5")
    //   .then(res => {
    //     console.log(res);
    //   });
      // .then(users => this.setState({
      //   user_id: users.first.user_id,
      //   user_email: users.first.user_email,
      //   username: users.first.username,
      //   user_biography: users.first.user_biography,
      // }))
    axios.get(`http://10.27.165.202:8080/api/user/${id}`)
      .then(res => {
        const charity = res.data;
        this.setState(charity);
      })
  }

  render () {
    const { classes } = this.props;
    return (
      <div>
        <NavigationBar id={'234'} isDonor={false} /> // TODO: id for what?
        <main
          className={clsx(classes.content, {
            [classes.contentShift]: open,
          })}
        >
          <h1>YOOOO</h1>
          <h1>{this.state.username}</h1>

        </main>
      </div>
    );
  }
}

export default withStyles(styles)(AccountPage);
