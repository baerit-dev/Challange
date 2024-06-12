import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatCardModule} from '@angular/material/card'; 
import { Movie, Projection } from '../../model/typings';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-movie-viewer',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, CommonModule],
  templateUrl: './movie-viewer.component.html',
  styleUrl: './movie-viewer.component.scss'
})
export class MovieViewerComponent {

  @Input()
  public projections: Projection[] = [];
}
