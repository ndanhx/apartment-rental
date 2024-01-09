import { Injectable } from '@angular/core';
import { Apartment } from '../model/apartment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApartmentType } from '../model/type';

@Injectable({
  providedIn: 'root',
})
export class ApartmentService {
  private baseURL =
    'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/apartment';

  constructor(private httpClient: HttpClient) {}

  getApartmentList(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(`${this.baseURL}`);
  }

  getApartmentListPosted(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(`${this.baseURL}/apartment-posted`);
  }
  getApartmentListPending(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(
      `${this.baseURL}/apartment-pending`
    );
  }
  getApartmentListSold(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(`${this.baseURL}/apartment-sold`);
  }

  getApartmentListActive(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(`${this.baseURL}/apartment-active`);
  }

  getApartmentListTop5Favorite(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(
      `${this.baseURL}/get-top-5-listing`
    );
  }

  deleteApartment(idApartment: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${idApartment}`);
  }
  createApartment(apartment: Apartment): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, apartment);
  }

  getApartmentById(apartment: Apartment): Observable<Apartment> {
    return this.httpClient.post<Apartment>(
      `${this.baseURL}/getApartment`,
      apartment
    );
  }

  updateApartment(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/update-apartment`, apartment);
  }

  activeApartment(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/update-active-apartment`,
      apartment
    );
  }

  soldApartment(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/update-sold-apartment`,
      apartment
    );
  }

  acceptListing(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/accept-listing-apartment`,
      apartment
    );
  }

  //SELLER

  getApartmentListOfSeller(apartment: Apartment): Observable<Apartment[]> {
    return this.httpClient.put<Apartment[]>(
      `${this.baseURL}/get-list-apartment-of-seller`,
      apartment
    );
  }

  getApartmentListOfSellerPost(apartment: Apartment): Observable<Apartment[]> {
    return this.httpClient.put<Apartment[]>(
      `${this.baseURL}/get-list-apartment-of-seller-posted`,
      apartment
    );
  }

  getApartmentListOfSellerPending(
    apartment: Apartment
  ): Observable<Apartment[]> {
    return this.httpClient.put<Apartment[]>(
      `${this.baseURL}/get-list-apartment-of-seller-pending`,
      apartment
    );
  }

  getApartmentListOfSellerSold(apartment: Apartment): Observable<Apartment[]> {
    return this.httpClient.put<Apartment[]>(
      `${this.baseURL}/get-list-apartment-of-seller-sold`,
      apartment
    );
  }

  //ALL role
  postListing(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/post-listing-apartment`,
      apartment
    );
  }
  rejectListing(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/reject-listing-apartment`,
      apartment
    );
  }

  getApartmentOfType(type: ApartmentType): Observable<Apartment[]> {
    return this.httpClient.put<Apartment[]>(
      `${this.baseURL}/get-list-apartment-of-type`,
      type
    );
  }

  getUrl: string;
  query(
    keyword: any,
    room: any,
    bathrooms: any,
    minPrice: any,
    idType: any,
    idWard: any
  ): string {
    this.getUrl =
      `${this.baseURL}/search?keyword=` +
      keyword +
      '&room=' +
      room +
      '&bath=' +
      bathrooms +
      '&minPrice=' +
      minPrice +
      '&idWard=' +
      idWard +
      '&idType=' +
      idType;

    return this.getUrl;
  }

  searchApartmentList(query): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(`${query}`);
  }

  checkApartmentValid(): Observable<Object> {
    return this.httpClient.get(`${this.baseURL}/check-apartment-valid`);
  }

  updateHeart(apartment: Apartment): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/update-heart`, apartment);
  }

  getApartmentListPostedLimit6(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(
      `${this.baseURL}/apartment-posted-limit-6`
    );
  }

  getApartmentListPostedLimit3Continue(
    offset: number
  ): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(
      `${this.baseURL}/apartment-posted-limit-3-continue?offset=${offset}`
    );
  }

  totalListingToday(): Observable<number> {
    return this.httpClient.get<number>(
      `${this.baseURL}/get-total-listing-today`
    );
  }
}
