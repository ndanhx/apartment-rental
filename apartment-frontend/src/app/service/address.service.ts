import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from '../model/city';
import { District } from '../model/district';
import { Ward } from '../model/ward';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  private baseURL =
    'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/address';

  constructor(private httpClient: HttpClient) {}

  getCitiesList(): Observable<City[]> {
    return this.httpClient.get<City[]>(`${this.baseURL}/city`);
  }

  getDistrictsByCity(district: District): Observable<District[]> {
    return this.httpClient.put<District[]>(
      `${this.baseURL}/district`,
      district
    );
  }

  getWardsByDistrict(ward: Ward): Observable<Ward[]> {
    return this.httpClient.put<Ward[]>(`${this.baseURL}/ward`, ward);
  }

  getAddressByIDWard(ward: Ward): Observable<String> {
    return this.httpClient.put<String>(`${this.baseURL}/get-address`, ward);
  }
}
