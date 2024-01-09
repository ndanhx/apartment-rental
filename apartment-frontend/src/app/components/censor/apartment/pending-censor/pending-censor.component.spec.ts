import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingCensorComponent } from './pending-censor.component';

describe('PendingCensorComponent', () => {
  let component: PendingCensorComponent;
  let fixture: ComponentFixture<PendingCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PendingCensorComponent]
    });
    fixture = TestBed.createComponent(PendingCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
