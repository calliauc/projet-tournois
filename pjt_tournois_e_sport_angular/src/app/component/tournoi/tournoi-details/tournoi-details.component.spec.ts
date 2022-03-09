import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TournoiDetailsComponent } from './tournoi-details.component';

describe('TournoiDetailsComponent', () => {
  let component: TournoiDetailsComponent;
  let fixture: ComponentFixture<TournoiDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TournoiDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TournoiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
