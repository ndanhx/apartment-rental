import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldApartmentComponent } from './sold-apartment.component';

describe('SoldApartmentComponent', () => {
  let component: SoldApartmentComponent;
  let fixture: ComponentFixture<SoldApartmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldApartmentComponent]
    });
    fixture = TestBed.createComponent(SoldApartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
