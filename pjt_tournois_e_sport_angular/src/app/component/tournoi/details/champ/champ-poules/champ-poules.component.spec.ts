import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampPoulesComponent } from './champ-poules.component';

describe('ChampPoulesComponent', () => {
  let component: ChampPoulesComponent;
  let fixture: ComponentFixture<ChampPoulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampPoulesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampPoulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
