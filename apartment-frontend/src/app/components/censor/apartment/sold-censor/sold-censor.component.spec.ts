import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldCensorComponent } from './sold-censor.component';

describe('SoldCensorComponent', () => {
  let component: SoldCensorComponent;
  let fixture: ComponentFixture<SoldCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SoldCensorComponent]
    });
    fixture = TestBed.createComponent(SoldCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
