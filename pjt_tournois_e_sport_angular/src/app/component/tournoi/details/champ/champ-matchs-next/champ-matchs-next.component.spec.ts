import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampMatchsNextComponent } from './champ-matchs-next.component';

describe('ChampMatchsNextComponent', () => {
  let component: ChampMatchsNextComponent;
  let fixture: ComponentFixture<ChampMatchsNextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChampMatchsNextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampMatchsNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
