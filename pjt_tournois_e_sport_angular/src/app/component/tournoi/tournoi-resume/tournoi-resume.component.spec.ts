import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TournoiResumeComponent } from './tournoi-resume.component';

describe('TournoiResumeComponent', () => {
  let component: TournoiResumeComponent;
  let fixture: ComponentFixture<TournoiResumeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TournoiResumeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TournoiResumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
