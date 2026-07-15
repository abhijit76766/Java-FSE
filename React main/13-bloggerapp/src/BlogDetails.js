import React from "react";

// 2. Conditional rendering with the ternary operator
function BlogDetails({ show }) {
  return show ? (
    <div><h3>Blog Details</h3><p>10 Tips for Learning React Faster</p></div>
  ) : null;
}

export default BlogDetails;
