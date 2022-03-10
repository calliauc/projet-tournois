import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueInscriptionComponent } from './ligue-inscription.component';

describe('LigueInscriptionComponent', () => {
  let component: LigueInscriptionComponent;
  let fixture: ComponentFixture<LigueInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
