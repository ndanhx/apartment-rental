import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckUserCensorComponent } from './check-user-censor.component';

describe('CheckUserCensorComponent', () => {
  let component: CheckUserCensorComponent;
  let fixture: ComponentFixture<CheckUserCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CheckUserCensorComponent]
    });
    fixture = TestBed.createComponent(CheckUserCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
