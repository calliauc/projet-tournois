import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurCompteComponent } from './utilisateur-compte.component';

describe('UtilisateurCompteComponent', () => {
  let component: UtilisateurCompteComponent;
  let fixture: ComponentFixture<UtilisateurCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurCompteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilisateurCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
