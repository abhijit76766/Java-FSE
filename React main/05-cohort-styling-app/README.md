# Exercise 5 - Cohort Details Styling

Since the original starter project was distributed as a separate
downloadable zip attachment (not part of the uploaded lab docs), this
solution recreates a minimal CohortDetails app and applies the
requested CSS Module styling:

- `CohortDetails.module.css` defines `.box` (300px width, inline-block,
  10px margin, 10/20px padding, 1px black border, 10px border-radius)
  and a tag selector for `dt` (font-weight 500).
- `CohortDetails.js` imports the module and applies `.box` to the
  container, with the `<h3>` colored green when status is "ongoing"
  and blue otherwise.
