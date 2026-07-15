import { Component, inject } from '@angular/core';
import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  templateUrl: './student-profile.component.html'
})
export class StudentProfileComponent {
  readonly enrollmentService = inject(EnrollmentService);
}
