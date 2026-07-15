import { Directive, ElementRef, HostListener, Input, inject } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  private readonly elementRef = inject(ElementRef<HTMLElement>);

  @Input() appHighlight = 'yellow';

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.elementRef.nativeElement.style.backgroundColor = this.appHighlight;
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.elementRef.nativeElement.style.backgroundColor = '';
  }
}
