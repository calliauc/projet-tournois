import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampionnatEditComponent } from './championnat-edit.component';

describe('ChampionnatEditComponent', () => {
  let component: ChampionnatEditComponent;
  let fixture: ComponentFixture<ChampionnatEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampionnatEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampionnatEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
