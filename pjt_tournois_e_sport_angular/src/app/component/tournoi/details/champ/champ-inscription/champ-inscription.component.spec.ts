import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampInscriptionComponent } from './champ-inscription.component';

describe('ChampInscriptionComponent', () => {
  let component: ChampInscriptionComponent;
  let fixture: ComponentFixture<ChampInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
