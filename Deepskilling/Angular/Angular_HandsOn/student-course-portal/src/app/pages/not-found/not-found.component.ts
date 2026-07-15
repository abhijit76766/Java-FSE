import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [RouterLink],
  template: `
    <h1 class="page-title">404</h1>
    <p>The page you requested was not found.</p>
    <a routerLink="/">Go home</a>
  `
})
export class NotFoundComponent {}
