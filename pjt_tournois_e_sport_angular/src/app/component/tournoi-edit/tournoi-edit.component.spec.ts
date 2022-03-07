import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TournoiEditComponent } from './tournoi-edit.component';

describe('TournoiEditComponent', () => {
  let component: TournoiEditComponent;
  let fixture: ComponentFixture<TournoiEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TournoiEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TournoiEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
