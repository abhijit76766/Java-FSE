import { Routes } from '@angular/router';
import { CourseDetailComponent } from './pages/course-detail/course-detail.component';
import { CourseListComponent } from './pages/course-list/course-list.component';
import { CoursesLayoutComponent } from './pages/courses-layout/courses-layout.component';
import { HomeComponent } from './pages/home/home.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { StudentProfileComponent } from './pages/student-profile/student-profile.component';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'courses',
    component: CoursesLayoutComponent,
    children: [
      { path: '', component: CourseListComponent },
      { path: ':id', component: CourseDetailComponent }
    ]
  },
  { path: 'profile', canActivate: [authGuard], component: StudentProfileComponent },
  {
    path: 'enroll',
    canActivate: [authGuard],
    loadChildren: () =>
      import('./features/enrollment/enrollment.routes').then((m) => m.enrollmentRoutes)
  },
  { path: '**', component: NotFoundComponent }
];
