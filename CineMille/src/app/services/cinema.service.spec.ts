import { TestBed } from '@angular/core/testing';

import { CinemaService } from './cinema.service';

describe('LoginService', () => {
  let service: CinemaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CinemaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
