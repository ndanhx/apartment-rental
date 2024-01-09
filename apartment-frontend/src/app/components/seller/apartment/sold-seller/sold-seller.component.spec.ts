import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldSellerComponent } from './sold-seller.component';

describe('SoldSellerComponent', () => {
  let component: SoldSellerComponent;
  let fixture: ComponentFixture<SoldSellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldSellerComponent]
    });
    fixture = TestBed.createComponent(SoldSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
