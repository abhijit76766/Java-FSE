import { Component, OnInit, inject } from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormControl,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';
import { CanLeaveWithDirtyForm } from '../../../guards/unsaved-changes.guard';

export function noCourseCode(control: AbstractControl): ValidationErrors | null {
  const value = String(control.value ?? '');
  return value.startsWith('XX') ? { noCourseCode: true } : null;
}

export function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise((resolve) => {
    setTimeout(() => {
      const value = String(control.value ?? '');
      resolve(value.includes('test@') ? { emailTaken: true } : null);
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrl: './reactive-enrollment-form.component.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit, CanLeaveWithDirtyForm {
  private readonly fb = inject(FormBuilder);

  enrollForm = this.fb.group({
    studentName: ['', [Validators.required, Validators.minLength(3)]],
    studentEmail: this.fb.control('', [Validators.required, Validators.email], [simulateEmailCheck]),
    courseId: ['', [Validators.required, noCourseCode]],
    preferredSemester: ['Odd', Validators.required],
    agreeToTerms: [false, Validators.requiredTrue],
    additionalCourses: this.fb.array<FormControl<string>>([])
  });

  ngOnInit(): void {}

  get additionalCourses(): FormArray<FormControl<string>> {
    // The getter centralises the cast so the template stays typed and simple.
    return this.enrollForm.get('additionalCourses') as FormArray<FormControl<string>>;
  }

  addCourse(): void {
    this.additionalCourses.push(this.fb.control('', { nonNullable: true, validators: Validators.required }));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    console.log(this.enrollForm.value);
    // value excludes disabled controls; getRawValue includes every control whether disabled or enabled.
    console.log(this.enrollForm.getRawValue());
  }

  hasUnsavedChanges(): boolean {
    return this.enrollForm.dirty;
  }
}
