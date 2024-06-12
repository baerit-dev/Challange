import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CinemaService } from './services/cinema.service';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { LoginDialogComponent } from './components/login/login-dialog.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MovieViewerComponent } from './components/movie-viewer/movie-viewer.component';
import { Dir, Projection, Sort } from './model/typings';
import { CommonModule } from '@angular/common';
import { MatButtonToggleModule } from '@angular/material/button-toggle';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MatToolbarModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    MovieViewerComponent,
    CommonModule,
    MatButtonToggleModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  private loginDialogRef?: MatDialogRef<LoginDialogComponent>;
  private dir: Dir ='ASC';
  private sort: Sort ='start_date';

  public isLogged: boolean;
  public projections: Projection[] = [];
  public showLoading = false;

  constructor(private cinemaSvc: CinemaService, private matDialog: MatDialog) {
    this.isLogged = this.cinemaSvc.isUserLogged.getValue();
    this.cinemaSvc.isUserLogged.subscribe((event) => {
      if (event != this.isLogged) {
        this.isLogged = event;
        this.loadMovies();
        if (this.loginDialogRef) this.loginDialogRef.close();
      }
    });
  }

  ngOnInit(): void {
    this.loadMovies();
  }

  public onDirChange(dir: Dir): void {
    this.dir = dir;
    this.loadMovies();
  }

  public onSortChange(sort: Sort): void {
    this.sort = sort;
    this.loadMovies();
  }
  

  public openLoginLogoutDialog(): void {
    this.loginDialogRef = this.matDialog.open(LoginDialogComponent, {
      width: '400px',
    });
  }

  private loadMovies(): void {
    this.showLoading = true;
    let projections$ = this.cinemaSvc.getCurrentProjections(this.sort, this.dir);
    if (this.isLogged) projections$ = this.cinemaSvc.getAllProjections(this.sort, this.dir);

    projections$
      .subscribe({
        next: (proj) => (this.projections = proj),
      })
      .add(() => (this.showLoading = false));
  }
}
