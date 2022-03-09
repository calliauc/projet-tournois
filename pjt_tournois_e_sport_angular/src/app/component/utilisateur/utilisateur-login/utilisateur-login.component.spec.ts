import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurLoginComponent } from './utilisateur-login.component';

describe('UtilisateurLoginComponent', () => {
  let component: UtilisateurLoginComponent;
  let fixture: ComponentFixture<UtilisateurLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilisateurLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
