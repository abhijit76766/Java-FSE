import { Component, inject } from '@angular/core';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  template: `<p>Shared service course count: {{ courseCount }}</p>`
})
export class CourseSummaryWidgetComponent {
  private readonly courseService = inject(CourseService);
  readonly courseCount = this.courseService.getLocalCourses().length;
}
