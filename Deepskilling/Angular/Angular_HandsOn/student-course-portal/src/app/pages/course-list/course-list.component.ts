import { AsyncPipe } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable, Subject, switchMap } from 'rxjs';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { HighlightDirective } from '../../directives/highlight.directive';
import { Course, Student } from '../../models/course.model';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesError, selectCoursesLoading } from '../../store/course/course.selectors';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [AsyncPipe, FormsModule, CourseCardComponent, HighlightDirective],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {
  private readonly courseService = inject(CourseService);
  private readonly enrollmentService = inject(EnrollmentService);
  private readonly route = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly store = inject(Store);

  courses$: Observable<Course[]> = this.store.select(selectAllCourses);
  loading$ = this.store.select(selectCoursesLoading);
  error$ = this.store.select(selectCoursesError);
  enrolledIds$ = this.store.select(selectEnrolledIds);
  studentsBySelectedCourse$: Observable<Student[]>;

  courses: Course[] = [];
  isLoading = true;
  selectedCourseId?: number;
  searchTerm = '';
  private readonly selectedCourseSubject = new Subject<number>();

  constructor() {
    this.studentsBySelectedCourse$ = this.selectedCourseSubject.pipe(
      // switchMap cancels the previous inner request when a newer course id is selected.
      switchMap((courseId) => this.enrollmentService.getStudentsByCourse(courseId))
    );
  }

  ngOnInit(): void {
    this.searchTerm = this.route.snapshot.queryParamMap.get('search') ?? '';
    this.courses = this.courseService.getLocalCourses();
    setTimeout(() => (this.isLoading = false), 1500);
    this.store.dispatch(loadCourses());
  }

  trackByCourseId(index: number, course: Course): number {
    // trackBy avoids re-rendering unchanged cards when the array changes.
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    this.selectedCourseSubject.next(courseId);
  }

  openCourse(course: Course): void {
    this.router.navigate(['courses', course.id]);
  }

  updateSearch(): void {
    this.router.navigate(['courses'], {
      queryParams: this.searchTerm ? { search: this.searchTerm } : {}
    });
  }
}
