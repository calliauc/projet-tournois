import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampDescriptionComponent } from './champ-description.component';

describe('ChampDescriptionComponent', () => {
  let component: ChampDescriptionComponent;
  let fixture: ComponentFixture<ChampDescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampDescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
