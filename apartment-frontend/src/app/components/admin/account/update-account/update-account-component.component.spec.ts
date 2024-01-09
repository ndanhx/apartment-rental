import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAccountComponentComponent } from './update-account-component.component';

describe('UpdateAccountComponentComponent', () => {
  let component: UpdateAccountComponentComponent;
  let fixture: ComponentFixture<UpdateAccountComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateAccountComponentComponent]
    });
    fixture = TestBed.createComponent(UpdateAccountComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
