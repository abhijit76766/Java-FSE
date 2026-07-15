import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges, inject } from '@angular/core';
import { Store } from '@ngrx/store';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { EnrollmentService } from '../../services/enrollment.service';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnChanges {
  private readonly enrollmentService = inject(EnrollmentService);
  private readonly store = inject(Store);

  @Input({ required: true }) course!: Course;
  @Input() enrolledIds: number[] | null = null;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Course changed', changes['course'].previousValue, changes['course'].currentValue);
    }
  }

  get isEnrolled(): boolean {
    return this.enrolledIds?.includes(this.course.id) ?? this.enrollmentService.isEnrolled(this.course.id);
  }

  get cardClasses(): Record<string, boolean> {
    // A getter keeps the template readable when multiple conditional classes are needed.
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': (this.course.credits ?? 0) >= 4,
      expanded: this.isExpanded
    };
  }

  get borderStyle(): Record<string, string> {
    const colorMap = {
      passed: '#16833a',
      failed: '#c9352b',
      pending: '#8b929e'
    };

    return { 'border-left-color': colorMap[this.course.gradeStatus] };
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  toggleEnrollment(): void {
    if (this.isEnrolled) {
      this.enrollmentService.unenroll(this.course.id);
      this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
    } else {
      this.enrollmentService.enroll(this.course.id);
      this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
    }

    this.enrollRequested.emit(this.course.id);
  }
}
