import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationCompteComponent } from './creation-compte.component';

describe('InscriptionComponent', () => {
  let component: CreationCompteComponent;
  let fixture: ComponentFixture<CreationCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreationCompteComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
