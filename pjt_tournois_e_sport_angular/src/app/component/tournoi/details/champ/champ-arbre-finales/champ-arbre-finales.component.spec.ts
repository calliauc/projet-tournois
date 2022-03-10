import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampArbreFinalesComponent } from './champ-arbre-finales.component';

describe('ChampArbreFinalesComponent', () => {
  let component: ChampArbreFinalesComponent;
  let fixture: ComponentFixture<ChampArbreFinalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampArbreFinalesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampArbreFinalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
