# Exercise 19 - gitclientapp

`GitClient.js` — class that calls `api.github.com/users/{username}/repos`
via axios and exposes `getRepositories()`, returning just the repo
names.
`App.js` — fetches and displays the repo list for user "techiesyed" in
`componentDidMount()`.
`GitClient.test.js` — `jest.mock("axios")` mocks the HTTP call so
`getRepositories()` is tested in isolation against dummy data, without
hitting the real GitHub API.

Install: `npm install axios`
Run tests: `npm test`
