import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostedCensorComponent } from './posted-censor.component';

describe('PostedCensorComponent', () => {
  let component: PostedCensorComponent;
  let fixture: ComponentFixture<PostedCensorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostedCensorComponent]
    });
    fixture = TestBed.createComponent(PostedCensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
