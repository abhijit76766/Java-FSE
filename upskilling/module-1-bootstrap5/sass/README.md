# Bootstrap Sass Customization

Exercise 19 solution outline:

```bash
npm init -y
npm install bootstrap sass
```

Create `scss/custom.scss`:

```scss
@import "variables";
@import "../node_modules/bootstrap/scss/bootstrap";
```

Compile:

```bash
npx sass scss/custom.scss css/custom.css
```
