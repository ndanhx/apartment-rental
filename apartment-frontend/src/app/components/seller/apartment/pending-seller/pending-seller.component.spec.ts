import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingSellerComponent } from './pending-seller.component';

describe('PendingSellerComponent', () => {
  let component: PendingSellerComponent;
  let fixture: ComponentFixture<PendingSellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PendingSellerComponent]
    });
    fixture = TestBed.createComponent(PendingSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
