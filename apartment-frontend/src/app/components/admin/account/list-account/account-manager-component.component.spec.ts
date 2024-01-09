import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountManagerComponentComponent } from './account-manager-component.component';

describe('AccountManagerComponentComponent', () => {
  let component: AccountManagerComponentComponent;
  let fixture: ComponentFixture<AccountManagerComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountManagerComponentComponent]
    });
    fixture = TestBed.createComponent(AccountManagerComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
