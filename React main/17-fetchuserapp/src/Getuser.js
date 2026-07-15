import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      firstName: "",
      picture: "",
      loading: true
    };
  }

  componentDidMount() {
    fetch("https://randomuser.me/api/")
      .then((response) => response.json())
      .then((data) => {
        const user = data.results[0];
        this.setState({
          title: user.name.title,
          firstName: user.name.first,
          picture: user.picture.large,
          loading: false
        });
      })
      .catch((error) => {
        console.error("Error fetching user:", error);
        this.setState({ loading: false });
      });
  }

  render() {
    if (this.state.loading) {
      return <p>Loading user...</p>;
    }

    return (
      <div>
        <h2>
          {this.state.title} {this.state.firstName}
        </h2>
        <img src={this.state.picture} alt={this.state.firstName} />
      </div>
    );
  }
}

export default Getuser;
