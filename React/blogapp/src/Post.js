// Simple model class representing a single blog Post.
// Mirrors the shape of objects returned by
// https://jsonplaceholder.typicode.com/posts
class Post {
  constructor(userId, id, title, body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

export default Post;
