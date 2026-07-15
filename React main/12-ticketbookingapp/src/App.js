import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    return (
      <div>
        <h1>Ticket Booking App</h1>
        {this.state.isLoggedIn ? (
          <button onClick={this.handleLogout}>Logout</button>
        ) : (
          <button onClick={this.handleLogin}>Login</button>
        )}

        {this.state.isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default App;
