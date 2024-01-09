import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingApartmentComponent } from './pending-apartment.component';

describe('PendingApartmentComponent', () => {
  let component: PendingApartmentComponent;
  let fixture: ComponentFixture<PendingApartmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PendingApartmentComponent]
    });
    fixture = TestBed.createComponent(PendingApartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
