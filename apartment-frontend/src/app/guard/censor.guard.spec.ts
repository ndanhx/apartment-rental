import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { censorGuard } from './censor.guard';

describe('censorGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => censorGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
