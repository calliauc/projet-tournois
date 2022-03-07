import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appBlackWhiteText]',
})
export class BlackWhiteTextDirective {
  constructor(private el: ElementRef) {
    this.el.nativeElement.style.backgroundColor = 'black';
    this.el.nativeElement.style.color = 'white';
  }
}
