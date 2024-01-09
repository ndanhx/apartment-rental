import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostedApartmentComponent } from './posted-apartment.component';

describe('PostedApartmentComponent', () => {
  let component: PostedApartmentComponent;
  let fixture: ComponentFixture<PostedApartmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostedApartmentComponent]
    });
    fixture = TestBed.createComponent(PostedApartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
