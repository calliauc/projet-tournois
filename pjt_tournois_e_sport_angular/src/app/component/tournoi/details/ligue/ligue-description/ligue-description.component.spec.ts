import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueDescriptionComponent } from './ligue-description.component';

describe('LigueDescriptionComponent', () => {
  let component: LigueDescriptionComponent;
  let fixture: ComponentFixture<LigueDescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueDescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
