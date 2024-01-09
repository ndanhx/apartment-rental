import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveAccCensorComponent } from './active-acc-censor.component';

describe('ActiveAccCensorComponent', () => {
  let component: ActiveAccCensorComponent;
  let fixture: ComponentFixture<ActiveAccCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActiveAccCensorComponent]
    });
    fixture = TestBed.createComponent(ActiveAccCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
