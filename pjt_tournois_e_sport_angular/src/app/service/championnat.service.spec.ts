/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ChampionnatService } from './championnat.service';

describe('Service: Championnat', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChampionnatService],
    });
  });

  it('should ...', inject(
    [ChampionnatService],
    (service: ChampionnatService) => {
      expect(service).toBeTruthy();
    }
  ));
});
