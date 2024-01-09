import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavCensorComponent } from './nav-censor.component';

describe('NavCensorComponent', () => {
  let component: NavCensorComponent;
  let fixture: ComponentFixture<NavCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavCensorComponent]
    });
    fixture = TestBed.createComponent(NavCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
