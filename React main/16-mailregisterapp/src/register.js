import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  }

  validate() {
    const { name, email, password } = this.state;
    const errors = {};

    if (name.trim().length < 5) {
      errors.name = "Name should have at least 5 characters";
    }
    if (!email.includes("@") || !email.includes(".")) {
      errors.email = "Email should contain @ and .";
    }
    if (password.length < 8) {
      errors.password = "Password should have at least 8 characters";
    }

    return errors;
  }

  handleSubmit(event) {
    event.preventDefault();
    const errors = this.validate();
    this.setState({ errors });

    if (Object.keys(errors).length === 0) {
      alert("Registration successful for " + this.state.name);
    }
  }

  render() {
    const { name, email, password, errors } = this.state;

    return (
      <div>
        <h2>Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>
              Name:
              <input type="text" name="name" value={name} onChange={this.handleChange} />
            </label>
            {errors.name && <p style={{ color: "red" }}>{errors.name}</p>}
          </div>
          <div>
            <label>
              Email:
              <input type="text" name="email" value={email} onChange={this.handleChange} />
            </label>
            {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
          </div>
          <div>
            <label>
              Password:
              <input
                type="password"
                name="password"
                value={password}
                onChange={this.handleChange}
              />
            </label>
            {errors.password && <p style={{ color: "red" }}>{errors.password}</p>}
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Register;
