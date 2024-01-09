import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApartmentCensorComponent } from './apartment-censor.component';

describe('ApartmentCensorComponent', () => {
  let component: ApartmentCensorComponent;
  let fixture: ComponentFixture<ApartmentCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApartmentCensorComponent]
    });
    fixture = TestBed.createComponent(ApartmentCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
