import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JourneeEditComponent } from './journee-edit.component';

describe('JourneeEditComponent', () => {
  let component: JourneeEditComponent;
  let fixture: ComponentFixture<JourneeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JourneeEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JourneeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
