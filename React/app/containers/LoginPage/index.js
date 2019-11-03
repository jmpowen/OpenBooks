//
// import React from 'react';
// import PropTypes from 'prop-types';
// import { connect } from 'react-redux';
// import { withStyles } from '@material-ui/core/styles';
// import NavigationBar from '../../components/NavigationBar/Loadable';
//
// const styles = {
//   root: {
//     display: 'flex',
//     alignItems: 'center',
//     padding: '100px',
//     justifyContent: 'flex',
//   },
// }
//
// class LoginPage extends React.Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       email: "",
//       password: "",
//       save: false,
//     };
//
//     this.handleCheckbox.bind(this);
//     this.handleChange.bind(this);
//     this.handleSubmit.bind(this);
//   }
//
//   render() {
//     const { classes } = this.props;
//     const { email, password } = this.state;
//     return (
//       <div>
//         <div>
//           <NavigationBar />
//         </div>
//         <div className={classes.root}>
//           <form onSubmit={this.handleSubmit}>
//             <label htmlFor="email">Email</label>
//             <br />
//             <input
//               name="email"
//               type="text"
//               placeholder="Enter your email"
//               value={email}
//               onChange={this.handleChange}
//             />
//             <br />
//             <label htmlFor="email">Password</label>
//             <br />
//             <input
//               name="password"
//               type="password"
//               placeholder="Enter your password"
//               value={password}
//               onChange={this.handleChange}
//             />
//             <br />
//             <label htmlFor="remember">Remember me </label>
//             <input
//               name="Remember me"
//               type="checkbox"
//               onClick={this.handleCheckbox}
//             />
//             <br />
//             <button type="submit">Login</button>
//           </form>
//         </div>
//       </div>
//     );
//   }
//
//   handleCheckbox = () => {
//     this.setState({ save: !this.state.save})
//   }
//
//   handleChange = event => {
//     this.setState({
//       [event.target.name]: event.target.value
//     });
//   };
// 
//   handleSubmit = event => {
//     event.preventDefault();
//     //TODO api call here AXIOS
//   };
// }
//
// LoginPage.propTypes = {
//   classes: PropTypes.any,
// }
//
// const mapStateToProps = state => {
//   return {
//     email: state.email,
//     password: state.password,
//     save: state.save,
//   }
// }
//
// const mapDispatchToProps =
//
// export default withStyles(styles)(LoginPage);
