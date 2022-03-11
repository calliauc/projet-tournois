import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampPouleSoloComponent } from './champ-poule-solo.component';

describe('ChampPouleSoloComponent', () => {
  let component: ChampPouleSoloComponent;
  let fixture: ComponentFixture<ChampPouleSoloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampPouleSoloComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampPouleSoloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
