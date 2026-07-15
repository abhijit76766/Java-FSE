# Exercise 18 - Cohort Details Unit Testing (Jest + Enzyme)

The original starter application was distributed as a separate
downloadable zip attachment, not part of the uploaded lab docs, so
this solution recreates a minimal `CohortDetails` component and
covers it with the requested test suite.

Install:
```
npm install --save enzyme @wojtekmaj/enzyme-adapter-react-17
```
(React 17 adapter is used because the official `enzyme-adapter-react-16`
does not support React 17/18; swap accordingly if your CRA version
uses React 18 — see note below.)

`setupTests.js` configures the Enzyme adapter.
`CohortDetails.test.js` — suite `"Cohort Details Component"` with:
1. **should create the component** — `shallow` render, isolation check.
2. **should initialize the props** — `mount` + prop matcher.
3. **should display cohort code in h3** — `mount` + `find("h3")`.
4. **should always render same html** — snapshot test via `toMatchSnapshot()`.

Run: `npm test`
