import { CanDeactivateFn } from '@angular/router';

export interface CanLeaveWithDirtyForm {
  hasUnsavedChanges(): boolean;
}

export const unsavedChangesGuard: CanDeactivateFn<CanLeaveWithDirtyForm> = (component) => {
  if (!component.hasUnsavedChanges()) {
    return true;
  }

  return window.confirm('You have unsaved changes. Leave?');
};
