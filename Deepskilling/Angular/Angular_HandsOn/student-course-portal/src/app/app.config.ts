import { ApplicationConfig } from '@angular/core';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { routes } from './app.routes';
import { authInterceptor } from './interceptors/auth.interceptor';
import { errorHandlerInterceptor } from './interceptors/error-handler.interceptor';
import { loadingInterceptor } from './interceptors/loading.interceptor';
import { courseFeatureKey, courseReducer } from './store/course/course.reducer';
import { CourseEffects } from './store/course/course.effects';
import { enrollmentFeatureKey, enrollmentReducer } from './store/enrollment/enrollment.reducer';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor, errorHandlerInterceptor, loadingInterceptor])),
    provideStore({
      [courseFeatureKey]: courseReducer,
      [enrollmentFeatureKey]: enrollmentReducer
    }),
    provideEffects([CourseEffects]),
    provideStoreDevtools({ maxAge: 25 })
  ]
};
