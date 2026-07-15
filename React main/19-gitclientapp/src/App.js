import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { repos: [], loading: true, error: null };
    this.gitClient = new GitClient("techiesyed");
  }

  componentDidMount() {
    this.gitClient
      .getRepositories()
      .then((repos) => this.setState({ repos, loading: false }))
      .catch((error) => this.setState({ error: error.message, loading: false }));
  }

  render() {
    const { repos, loading, error } = this.state;

    if (loading) return <p>Loading repositories...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
      <div>
        <h1>GitHub Repositories</h1>
        <ul>
          {repos.map((name, index) => (
            <li key={index}>{name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;
