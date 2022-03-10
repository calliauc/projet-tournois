import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchResultatEditComponent } from './match-resultat-edit.component';

describe('MatchResultatEditComponent', () => {
  let component: MatchResultatEditComponent;
  let fixture: ComponentFixture<MatchResultatEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchResultatEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchResultatEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
