import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PersonsService {
  private API_SERVER = "http://localhost:4200/api/v1/persons"

  constructor(private httpClient: HttpClient) { }

  public getAllPersons(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }

  public savePerson(person: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER, person);
  }

}
