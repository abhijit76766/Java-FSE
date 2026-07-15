import React from "react";

// 1. Conditional rendering with if/else inside the function
function BookDetails({ show }) {
  if (!show) {
    return null;
  }
  return <div><h3>Book Details</h3><p>Atomic Habits by James Clear</p></div>;
}

export default BookDetails;
