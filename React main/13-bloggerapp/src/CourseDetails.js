import React from "react";

// 3. Conditional rendering with the logical && operator
function CourseDetails({ show }) {
  return (
    <div>
      {show && (
        <div>
          <h3>Course Details</h3>
          <p>Full Stack Java + React Developer Course</p>
        </div>
      )}
    </div>
  );
}

export default CourseDetails;
