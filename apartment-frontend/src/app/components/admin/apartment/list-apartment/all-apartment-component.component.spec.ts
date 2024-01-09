import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllApartmentComponentComponent } from './all-apartment-component.component';

describe('AllApartmentComponentComponent', () => {
  let component: AllApartmentComponentComponent;
  let fixture: ComponentFixture<AllApartmentComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllApartmentComponentComponent]
    });
    fixture = TestBed.createComponent(AllApartmentComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
