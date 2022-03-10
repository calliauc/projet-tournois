import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchsNextComponent } from './matchs-next.component';

describe('MatchsNextComponent', () => {
  let component: MatchsNextComponent;
  let fixture: ComponentFixture<MatchsNextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchsNextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchsNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
