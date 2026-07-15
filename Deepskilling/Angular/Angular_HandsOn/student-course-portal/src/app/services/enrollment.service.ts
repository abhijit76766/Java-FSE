import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Course, Student } from '../models/course.model';
import { CourseService } from './course.service';

@Injectable({ providedIn: 'root' })
export class EnrollmentService {
  private readonly courseService = inject(CourseService);
  private readonly http = inject(HttpClient);
  private readonly enrolledCourseIds: number[] = [];

  enroll(courseId: number): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    const index = this.enrolledCourseIds.indexOf(courseId);
    if (index >= 0) {
      this.enrolledCourseIds.splice(index, 1);
    }
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    return this.enrolledCourseIds
      .map((id) => this.courseService.getLocalCourseById(id))
      .filter((course): course is Course => Boolean(course));
  }

  getStudentsByCourse(courseId: number): Observable<Student[]> {
    return this.http
      .get<Array<{ id: number; courseId: number; studentId: number }>>(
        `http://localhost:3000/enrollments?courseId=${courseId}`
      )
      .pipe(
        map((enrollments) => enrollments.map((item) => item.studentId)),
        map((studentIds) =>
          studentIds.map((id) => ({ id, name: `Student ${id}`, email: `student${id}@college.edu` }))
        )
      );
  }
}
