import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApartmentType } from '../model/type';

@Injectable({
  providedIn: 'root',
})
export class TypeService {
  private baseURL = 'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/type';

  constructor(private httpClient: HttpClient) {}

  getAllTypes(): Observable<ApartmentType[]> {
    return this.httpClient.get<ApartmentType[]>(`${this.baseURL}`);
  }

  createType(addType: ApartmentType): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, addType);
  }

  getTypeByID(type: ApartmentType): Observable<ApartmentType> {
    return this.httpClient.post<ApartmentType>(
      `${this.baseURL}/get-type-by-id`,
      type
    );
  }

  deleteType(idType: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${idType}`);
  }
}
