import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Dir, Projection, Sort } from '../model/typings';

@Injectable({
  providedIn: 'root',
})
export class CinemaService {
  private readonly BASE_URL = 'http://localhost:8080/';
  private username: string = '';
  private password: string = '';

  public isUserLogged = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) {}

  public login(username: string, password: string): Observable<boolean> {
    const params = new HttpParams()
      .append('user', username)
      .append('password', password);
    return this.http
      .get<boolean>(`${this.BASE_URL}users/login`, { params: params })
      .pipe(
        map((result) => {
          if (result) {
            this.username = username;
            this.password = password;
          }
          this.isUserLogged.next(result);
          return result;
        })
      );
  }

  public logout(): void {
    this.username = '';
    this.password = '';
    this.isUserLogged.next(false);
  }

  public getCurrentProjections(sort: Sort, dir: Dir): Observable<Projection[]> {
    const params = new HttpParams().append('sort', sort).append('dir', dir);
    return this.http.get<Projection[]>(`${this.BASE_URL}movies/current`, {
      params: params,
    });
  }

  public getAllProjections(sort: Sort, dir: Dir): Observable<Projection[]> {
    const params = new HttpParams().append('sort', sort).append('dir', dir);
    const headers = new HttpHeaders().append(
      'Authorization',
      'Basic ' + btoa(`${this.username}:${this.password}`)
    );
    return this.http.get<Projection[]>(`${this.BASE_URL}movies/`, {
      headers: headers,
      params: params,
    });
  }
}
