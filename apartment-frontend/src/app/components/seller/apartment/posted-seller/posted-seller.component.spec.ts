import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostedSellerComponent } from './posted-seller.component';

describe('PostedSellerComponent', () => {
  let component: PostedSellerComponent;
  let fixture: ComponentFixture<PostedSellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostedSellerComponent]
    });
    fixture = TestBed.createComponent(PostedSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
