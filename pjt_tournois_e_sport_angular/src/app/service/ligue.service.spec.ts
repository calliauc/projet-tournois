/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { LigueService } from './ligue.service';

describe('Service: Ligue', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LigueService]
    });
  });

  it('should ...', inject([LigueService], (service: LigueService) => {
    expect(service).toBeTruthy();
  }));
});
