import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMessage: ""
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch posts: " + response.status);
        }
        return response.json();
      })
      .then((data) => {
        const posts = data
          .slice(0, 10)
          .map((item) => new Post(item.id, item.title, item.body));
        this.setState({ posts });
      })
      .catch((error) => {
        this.setState({ hasError: true, errorMessage: error.message });
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("Something went wrong while rendering posts: " + error.message);
  }

  render() {
    if (this.state.hasError) {
      return <p>Unable to load posts: {this.state.errorMessage}</p>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
