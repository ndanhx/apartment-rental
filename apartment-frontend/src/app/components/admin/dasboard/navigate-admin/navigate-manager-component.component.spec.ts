import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigateManagerComponentComponent } from './navigate-manager-component.component';

describe('NavigateManagerComponentComponent', () => {
  let component: NavigateManagerComponentComponent;
  let fixture: ComponentFixture<NavigateManagerComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavigateManagerComponentComponent]
    });
    fixture = TestBed.createComponent(NavigateManagerComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
