import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArbreFinalesComponent } from './arbre-finales.component';

describe('ArbreFinalesComponent', () => {
  let component: ArbreFinalesComponent;
  let fixture: ComponentFixture<ArbreFinalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArbreFinalesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArbreFinalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
