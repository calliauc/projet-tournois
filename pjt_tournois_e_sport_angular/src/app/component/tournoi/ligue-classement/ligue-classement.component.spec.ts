import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueClassementComponent } from './ligue-classement.component';

describe('LigueClassementComponent', () => {
  let component: LigueClassementComponent;
  let fixture: ComponentFixture<LigueClassementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueClassementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueClassementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
