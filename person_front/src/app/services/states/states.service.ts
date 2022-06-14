import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StatesService {

  private API_SERVER = "http://localhost:8080/api/v1/states/";

  constructor(private httpClient: HttpClient) { }

  getAllStatesByCountry(id: Number): Observable<any> {
    return this.httpClient.get(this.API_SERVER + id)
  }

}
