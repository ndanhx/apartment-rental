import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountCensorComponent } from './account-censor.component';

describe('AccountCensorComponent', () => {
  let component: AccountCensorComponent;
  let fixture: ComponentFixture<AccountCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountCensorComponent]
    });
    fixture = TestBed.createComponent(AccountCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
