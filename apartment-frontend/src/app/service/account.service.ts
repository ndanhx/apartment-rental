import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../model/account';
import { Observable } from 'rxjs';
import * as moment from 'moment';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  private baseURL =
    'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/account';

  constructor(private httpClient: HttpClient) {}

  getAccountsList(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(`${this.baseURL}`);
  }
  getAccountLocked(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(`${this.baseURL}/get-account-lock`);
  }
  getAccountActive(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(`${this.baseURL}/get-account-active`);
  }
  getAccountVerified(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(
      `${this.baseURL}/get-account-verified`
    );
  }

  getAccountById(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(
      `${this.baseURL}/get-account-by-id`,
      account
    );
  }

  updateAccount(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/`, account);
  }
  deleteAccount(idAccount: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${idAccount}`);
  }

  checkLoginAccount(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(`${this.baseURL}/login`, account);
  }

  createAccount(account: Account): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/`, account);
  }

  lockAccount(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/active/lock`, account);
  }

  unLockAccount(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/active/unlock`, account);
  }

  verifyAccount(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/do-verify`, account);
  }
  removeVerifyAccount(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/remove-verify`, account);
  }

  updateAccountButAdmin(account: Account): Observable<Object> {
    return this.httpClient.put(
      `${this.baseURL}/update-account-but-admin`,
      account
    );
  }

  changePassword(account: Account): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/change-password`, account);
  }

  is_checkUserLogin() {
    const str = localStorage.getItem('expires_at') || '';
    if (str == '') return false; //chưa dn
    const expiresAt = JSON.parse(str);
    return moment().isBefore(moment(expiresAt));
  }
  logout() {
    localStorage.removeItem('username');
    localStorage.removeItem('expires_at');
    localStorage.removeItem('idAccount');
  }

  checkRoleUser(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(
      `${this.baseURL}/check-role-user`,
      account
    );
  }

  totalAccountThisYear(): Observable<number> {
    return this.httpClient.get<number>(
      `${this.baseURL}/get-total-account-this-year`
    );
  }
}
