import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApartmentSellerComponent } from './apartment-seller.component';

describe('ApartmentSellerComponent', () => {
  let component: ApartmentSellerComponent;
  let fixture: ComponentFixture<ApartmentSellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApartmentSellerComponent]
    });
    fixture = TestBed.createComponent(ApartmentSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
