import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampDetailsComponent } from './champ-details.component';

describe('ChampDetailsComponent', () => {
  let component: ChampDetailsComponent;
  let fixture: ComponentFixture<ChampDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
