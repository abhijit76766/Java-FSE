import React, { Component } from "react";

class CounterButtons extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  increment = () => {
    this.setState((prev) => ({ count: prev.count + 1 }));
  };

  sayHello = () => {
    alert("Hello, this is a static message.");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  decrement = () => {
    this.setState((prev) => ({ count: prev.count - 1 }));
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handlePress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>
        <button onClick={this.handlePress}>OnPress</button>
      </div>
    );
  }
}

export default CounterButtons;
