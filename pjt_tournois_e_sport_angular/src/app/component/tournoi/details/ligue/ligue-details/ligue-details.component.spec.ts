import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueDetailsComponent } from './ligue-details.component';

describe('LigueDetailsComponent', () => {
  let component: LigueDetailsComponent;
  let fixture: ComponentFixture<LigueDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
