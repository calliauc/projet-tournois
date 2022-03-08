import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultatEditComponent } from './resultat-edit.component';

describe('ResultatEditComponent', () => {
  let component: ResultatEditComponent;
  let fixture: ComponentFixture<ResultatEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultatEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultatEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
