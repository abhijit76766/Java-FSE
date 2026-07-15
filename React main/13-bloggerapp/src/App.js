import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

// 4. Conditional rendering by switching which element variable is rendered
function App() {
  const [activeTab, setActiveTab] = useState("book");

  let content;
  if (activeTab === "book") {
    content = <BookDetails show={true} />;
  } else if (activeTab === "blog") {
    content = <BlogDetails show={true} />;
  } else {
    content = <CourseDetails show={true} />;
  }

  return (
    <div>
      <h1>Blogger App</h1>
      <button onClick={() => setActiveTab("book")}>Book</button>
      <button onClick={() => setActiveTab("blog")}>Blog</button>
      <button onClick={() => setActiveTab("course")}>Course</button>

      {/* element variable */}
      {content}
    </div>
  );
}

export default App;
