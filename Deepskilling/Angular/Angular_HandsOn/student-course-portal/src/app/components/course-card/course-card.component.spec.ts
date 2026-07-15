import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideMockStore } from '@ngrx/store/testing';
import { SimpleChange } from '@angular/core';
import { CourseCardComponent } from './course-card.component';
import { Course } from '../../models/course.model';

describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;
  const mockCourse: Course = {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent],
      providers: [
        provideHttpClient(),
        provideMockStore({ initialState: { enrollment: { enrolledCourseIds: [] } } })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
    component.course = mockCourse;
  });

  it('should create', () => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  it('should render input course name', () => {
    fixture.detectChanges();
    const heading = fixture.debugElement.query(By.css('h3')).nativeElement as HTMLElement;
    expect(heading.textContent).toContain('Data Structures');
  });

  it('should emit course id when enroll is clicked', () => {
    spyOn(component.enrollRequested, 'emit');
    fixture.detectChanges();
    fixture.debugElement.queryAll(By.css('button'))[1].nativeElement.click();
    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });

  it('should log when ngOnChanges receives course changes', () => {
    spyOn(console, 'log');
    component.ngOnChanges({
      course: new SimpleChange(undefined, mockCourse, true)
    });
    expect(console.log).toHaveBeenCalled();
  });

  it('should apply enrolled class when course is enrolled', () => {
    component.enrolledIds = [1];
    fixture.detectChanges();
    const card = fixture.debugElement.query(By.css('.course-card')).nativeElement as HTMLElement;
    expect(card.classList).toContain('card--enrolled');
  });
});
