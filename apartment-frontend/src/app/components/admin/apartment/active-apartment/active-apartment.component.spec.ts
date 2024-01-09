import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveApartmentComponent } from './active-apartment.component';

describe('ActiveApartmentComponent', () => {
  let component: ActiveApartmentComponent;
  let fixture: ComponentFixture<ActiveApartmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActiveApartmentComponent]
    });
    fixture = TestBed.createComponent(ActiveApartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
