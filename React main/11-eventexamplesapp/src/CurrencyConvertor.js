import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = { rupees: "", euro: null };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const rupees = parseFloat(this.state.rupees) || 0;
    const euro = (rupees / 90).toFixed(2); // approx conversion rate
    this.setState({ euro });
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Indian Rupees:
            <input type="number" value={this.state.rupees} onChange={this.handleChange} />
          </label>
          <button type="submit">Convert</button>
        </form>
        {this.state.euro !== null && <p>Euro: {this.state.euro}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
