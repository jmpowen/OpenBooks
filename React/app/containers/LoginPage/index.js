/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React from 'react';
import NavigationBar from '../../components/NavigationBar/Loadable';
import AccountPage from '../AccountPage/Loadable';
import { withStyles } from '@material-ui/core/styles';
import axios from 'axios';

const styles = {
  root: {
    display: 'flex',
    alignItems: 'center',
    padding: '100px',
    justifyContent: 'flex',
  },
}

class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      password: "",
      validated: false,
      is_mounted: false,
      userData: {}
    }

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleEmail = this.handleEmail.bind(this);
    this.handlePassword = this.handlePassword.bind(this);
  }

  componentDidMount() {
    this.setState({ is_mounted: true });
  }

  componentWillMount() {
    this.setState({ is_mounted: false });
  }

  handleSubmit(event) {
    event.preventDefault();
    if (this.state.is_mounted && this.state.email.length > 0) {
      const { email } = this.state;
      axios.get(`http://10.27.165.202:8080/api/user/${email}`)
      .then(res => {
        console.log(res);
        const userData = res.data;
        this.setState({ userData, validated: true });
      })
      .catch(err => {
        console.log(err);
      });
      this.props.history.push(`/account/${email}`);
    }
  }

  handleEmail(event) {
    this.setState({ email: event.target.value });
  }

  handlePassword(event) {
    this.setState({ password: event.target.value });
  }

  render() {
    const { classes } = this.props;
    const { email, password } = this.state;
    return (
      <div>
        <div>
        <NavigationBar />
        </div>
        <div className={classes.root}>
          <form onSubmit={this.handleSubmit}>
            <label htmlFor="email">Email</label>
            <br />
            <input
              name="email"
              type="text"
              placeholder="Enter your email"
              value={email}
              onChange={this.handleEmail}
            />
            <br />
            <label htmlFor="email">Password</label>
            <br />
            <input
              name="password"
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={this.handlePassword}
            />
            <br />
            <button type="submit">Login</button>
          </form>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(LoginPage);
