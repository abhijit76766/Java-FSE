import { Component, inject } from '@angular/core';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  providers: [NotificationService],
  template: `<button type="button" (click)="add()">Add notification</button>`
})
export class NotificationComponent {
  private readonly notificationService = inject(NotificationService);

  add(): void {
    // Component-level providers create a separate NotificationService instance scoped to this component tree.
    this.notificationService.add('New notification');
  }
}
