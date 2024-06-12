import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieViewerComponent } from './movie-viewer.component';

describe('MovieViewerComponent', () => {
  let component: MovieViewerComponent;
  let fixture: ComponentFixture<MovieViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieViewerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
