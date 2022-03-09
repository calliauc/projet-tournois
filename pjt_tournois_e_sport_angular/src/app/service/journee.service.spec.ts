/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { JourneeService } from './journee.service';

describe('Service: Journee', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JourneeService]
    });
  });

  it('should ...', inject([JourneeService], (service: JourneeService) => {
    expect(service).toBeTruthy();
  }));
});
