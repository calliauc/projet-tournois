import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JourneeDetailComponent } from './journee-detail.component';

describe('JourneeDetailComponent', () => {
  let component: JourneeDetailComponent;
  let fixture: ComponentFixture<JourneeDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JourneeDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JourneeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
