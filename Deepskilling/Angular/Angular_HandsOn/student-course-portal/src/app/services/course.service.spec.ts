import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;
  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Angular', code: 'WEB201', credits: 3, gradeStatus: 'pending' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting(), CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should get courses from the API', () => {
    service.getCourses().subscribe((courses) => expect(courses.length).toBe(2));
    httpMock.expectOne('http://localhost:3000/courses').flush(mockCourses);
  });

  it('should emit a friendly error when loading courses fails', () => {
    service.getCourses().subscribe({
      next: () => fail('expected error'),
      error: (error: Error) => expect(error.message).toContain('Failed to load courses')
    });

    for (let attempt = 0; attempt < 3; attempt++) {
      const request = httpMock.expectOne('http://localhost:3000/courses');
      request.flush('Server error', { status: 500, statusText: 'Server Error' });
    }
  });
});
