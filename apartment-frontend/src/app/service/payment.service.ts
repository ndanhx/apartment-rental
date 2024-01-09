import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Account } from '../model/account';
import { Observable } from 'rxjs';
import { PaymentReceipt } from '../model/payment';
@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  private baseURL =
    'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/payment';

  constructor(private httpClient: HttpClient) {}

  getListPaymentByIdAccount(account: Account): Observable<PaymentReceipt[]> {
    return this.httpClient.post<PaymentReceipt[]>(
      `${this.baseURL}/get-list-payment-by-account`,
      account
    );
  }

  getListPayment(): Observable<PaymentReceipt[]> {
    return this.httpClient.post<PaymentReceipt[]>(
      `${this.baseURL}/get-list-payment`,
      null
    );
  }
  getListPaymentToday(): Observable<PaymentReceipt[]> {
    return this.httpClient.post<PaymentReceipt[]>(
      `${this.baseURL}/get-list-payment-today`,
      null
    );
  }
  getTotalThisMonth(): Observable<number> {
    return this.httpClient.post<number>(
      `${this.baseURL}/get-total-amount-this-month`,
      null
    );
  }

  getUrl: string;
  query(start: any, end: any): string {
    this.getUrl =
      `${this.baseURL}/get-list-payment-by-date?start=` + start + '&end=' + end;
    return this.getUrl;
  }
}
