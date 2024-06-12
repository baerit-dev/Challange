import { Component } from '@angular/core';
import { MatButton } from '@angular/material/button';
import {
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { CinemaService } from '../../services/cinema.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-dialog-login',
  standalone: true,
  imports: [
    MatButton,
    MatDialogActions,
    MatDialogClose,
    MatDialogTitle,
    MatDialogContent,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login-dialog.component.html',
  styleUrl: './login-dialog.component.scss',
})
export class LoginDialogComponent {
  public hide = true;
  public isLogged: boolean;
  public form: FormGroup;

  constructor(private cinemaSvc: CinemaService) {
    this.isLogged = this.cinemaSvc.isUserLogged.getValue();
    this.cinemaSvc.isUserLogged.subscribe((event) => (this.isLogged = event));
    this.form = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  public hidePassword(): void {
    this.hide = !this.hide;
  }

  public login(): void {
    if (!this.isLogged) {
      const username = this.form.get('username')?.value;
      const password = this.form.get('password')?.value;
      this.cinemaSvc.login(username, password).subscribe();
    } else
      this.cinemaSvc.logout();
  }
}
