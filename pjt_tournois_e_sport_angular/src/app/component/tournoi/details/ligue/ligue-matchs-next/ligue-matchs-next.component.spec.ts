import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigueMatchsNextComponent } from './ligue-matchs-next.component';

describe('LigueMatchsNextComponent', () => {
  let component: LigueMatchsNextComponent;
  let fixture: ComponentFixture<LigueMatchsNextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigueMatchsNextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LigueMatchsNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
