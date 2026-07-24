import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    // Initialize state with an empty list of posts
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Fetches posts from the API and stores them in component state
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const posts = data.map(
          (item) => new Post(item.userId, item.id, item.title, item.body)
        );
        this.setState({ posts });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  }

  // Lifecycle hook - called once, right after the component mounts.
  // Good place to kick off data fetching.
  componentDidMount() {
    this.loadPosts();
  }

  // Lifecycle hook - catches errors thrown anywhere below this
  // component in the tree during rendering and displays an alert.
  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert('Something went wrong while rendering the posts: ' + error.message);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong while loading the posts.</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.length === 0 && <p>Loading posts...</p>}
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
