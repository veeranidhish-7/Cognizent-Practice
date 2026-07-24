# blogapp

Lab: Implement componentDidMount() and componentDidCatch() lifecycle
hooks. Fetches posts from https://jsonplaceholder.typicode.com/posts
and displays each post's title (heading) and body (paragraph).

## Files
- src/Post.js       -> simple model class for a single post
- src/Posts.js      -> class component: state, loadPosts(), componentDidMount(), componentDidCatch(), render()
- src/App.js         -> renders the Posts component

## How to run
1. Unzip this folder.
2. Open the folder in VS Code (or open a terminal inside it).
3. Install dependencies:
   npm install
4. Start the app:
   npm start
5. Browser opens automatically at http://localhost:3000

Note: this app calls a live public API (jsonplaceholder.typicode.com),
so you'll need an internet connection for the posts to load.
