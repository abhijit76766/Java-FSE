import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, catchError, map, retry, tap, throwError } from 'rxjs';
import { Course } from '../models/course.model';

@Injectable({ providedIn: 'root' })
export class CourseService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:3000/courses';

  private readonly fallbackCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Angular Fundamentals', code: 'WEB201', credits: 3, gradeStatus: 'pending' },
    { id: 3, name: 'Database Systems', code: 'DB301', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Cloud Computing', code: 'CL401', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Software Testing', code: 'QA210', credits: 2, gradeStatus: 'pending' }
  ];

  getLocalCourses(): Course[] {
    return this.fallbackCourses;
  }

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      retry(2),
      map((courses) => courses.filter((course) => (course.credits ?? 0) > 0)),
      tap((courses) => console.log('Courses loaded:', courses.length)),
      // tap is for logging side effects; map is used above for data transformation.
      catchError((err) => {
        console.error(err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      catchError(() => throwError(() => new Error('Course not found.')))
    );
  }

  getLocalCourseById(id: number): Course | undefined {
    return this.fallbackCourses.find((course) => course.id === id);
  }

  addCourse(course: Course): void {
    this.fallbackCourses.push(course);
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course);
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
