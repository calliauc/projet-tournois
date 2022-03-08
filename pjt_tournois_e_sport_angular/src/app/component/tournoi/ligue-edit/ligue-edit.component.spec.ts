import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueEditComponent } from './ligue-edit.component';

describe('LigueEditComponent', () => {
  let component: LigueEditComponent;
  let fixture: ComponentFixture<LigueEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
