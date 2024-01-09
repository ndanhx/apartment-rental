import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionAdminComponent } from './transaction-admin.component';

describe('TransactionAdminComponent', () => {
  let component: TransactionAdminComponent;
  let fixture: ComponentFixture<TransactionAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TransactionAdminComponent]
    });
    fixture = TestBed.createComponent(TransactionAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
