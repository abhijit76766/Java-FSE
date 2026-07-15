import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { By } from '@angular/platform-browser';
import { CourseListComponent } from './course-list.component';
import { Course } from '../../models/course.model';

describe('CourseListComponent with MockStore', () => {
  let fixture: ComponentFixture<CourseListComponent>;
  let store: MockStore;
  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' }
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseListComponent],
      providers: [
        provideHttpClient(),
        provideRouter([]),
        provideMockStore({
          initialState: {
            course: { courses: mockCourses, loading: false, error: null },
            enrollment: { enrolledCourseIds: [] }
          }
        })
      ]
    }).compileComponents();

    store = TestBed.inject(MockStore);
    fixture = TestBed.createComponent(CourseListComponent);
  });

  it('should render course cards from store state', () => {
    fixture.detectChanges();
    expect(fixture.debugElement.queryAll(By.css('app-course-card')).length).toBe(1);
  });

  it('should show loading indicator from store state', () => {
    store.setState({
      course: { courses: [], loading: true, error: null },
      enrollment: { enrolledCourseIds: [] }
    });
    fixture.detectChanges();
    expect(fixture.nativeElement.textContent).toContain('Loading courses');
  });
});
