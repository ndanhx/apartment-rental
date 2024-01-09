import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSellerComponent } from './update-seller.component';

describe('UpdateSellerComponent', () => {
  let component: UpdateSellerComponent;
  let fixture: ComponentFixture<UpdateSellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateSellerComponent]
    });
    fixture = TestBed.createComponent(UpdateSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
