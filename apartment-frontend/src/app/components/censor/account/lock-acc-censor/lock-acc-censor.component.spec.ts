import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LockAccCensorComponent } from './lock-acc-censor.component';

describe('LockAccCensorComponent', () => {
  let component: LockAccCensorComponent;
  let fixture: ComponentFixture<LockAccCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LockAccCensorComponent]
    });
    fixture = TestBed.createComponent(LockAccCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
