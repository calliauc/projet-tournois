import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueJourneesComponent } from './ligue-journees.component';

describe('LigueJourneesComponent', () => {
  let component: LigueJourneesComponent;
  let fixture: ComponentFixture<LigueJourneesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueJourneesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueJourneesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
