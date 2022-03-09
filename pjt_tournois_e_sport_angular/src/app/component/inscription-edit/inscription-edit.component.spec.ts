import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionEditComponent } from './inscription-edit.component';

describe('InscriptionEditComponent', () => {
  let component: InscriptionEditComponent;
  let fixture: ComponentFixture<InscriptionEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
