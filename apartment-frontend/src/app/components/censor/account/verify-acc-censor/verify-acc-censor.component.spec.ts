import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifyAccCensorComponent } from './verify-acc-censor.component';

describe('VerifyAccCensorComponent', () => {
  let component: VerifyAccCensorComponent;
  let fixture: ComponentFixture<VerifyAccCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VerifyAccCensorComponent]
    });
    fixture = TestBed.createComponent(VerifyAccCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
