import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = { employeeName: "", complaint: "" };
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleComplaintChange = this.handleComplaintChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleNameChange(event) {
    this.setState({ employeeName: event.target.value });
  }

  handleComplaintChange(event) {
    this.setState({ complaint: event.target.value });
  }

  generateReferenceNumber() {
    return "REF-" + Math.floor(100000 + Math.random() * 900000);
  }

  handleSubmit(event) {
    event.preventDefault();
    const refNumber = this.generateReferenceNumber();
    alert(
      `Complaint registered for ${this.state.employeeName}.\nReference Number: ${refNumber}`
    );
    this.setState({ employeeName: "", complaint: "" });
  }

  render() {
    return (
      <div>
        <h2>Complaint Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>
              Employee Name:
              <input
                type="text"
                value={this.state.employeeName}
                onChange={this.handleNameChange}
              />
            </label>
          </div>
          <div>
            <label>
              Complaint:
              <textarea
                value={this.state.complaint}
                onChange={this.handleComplaintChange}
              />
            </label>
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
