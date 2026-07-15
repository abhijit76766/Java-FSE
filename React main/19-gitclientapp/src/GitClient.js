import axios from "axios";

class GitClient {
  constructor(username) {
    this.username = username;
    this.baseUrl = "https://api.github.com";
  }

  getRepositories() {
    return axios
      .get(`${this.baseUrl}/users/${this.username}/repos`)
      .then((response) => response.data.map((repo) => repo.name));
  }
}

export default GitClient;
