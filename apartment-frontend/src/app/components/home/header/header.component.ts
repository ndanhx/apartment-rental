import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import { PaymentService } from 'src/app/service/payment.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(
    private accountService: AccountService,
    private router: Router,
    private paymentService: PaymentService
  ) {}
  username: string;
  account: Account = new Account();

  ngOnInit(): void {
    if (this.checkLogin() === false) {
      this.accountService.logout();
    }
    this.username = localStorage.getItem('username');
    this.account.idAccount = Number(localStorage.getItem('idAccount'));
    this.accountService.getAccountById(this.account).subscribe(
      (data) => {
        this.account = data;
      },
      (error) => console.log(error)
    );
  }
  checkLogin() {
    return this.accountService.is_checkUserLogin();
  }

  logout() {
    this.accountService.logout();
    this.router.navigate(['home']);
    this.ngOnInit();
  }
  deposit(account: Account) {
    this.accountService.getAccountById(account).subscribe(
      (dataAccount) => {
        account = dataAccount;

        var queryString = Object.keys(account)
          .map((key) => key + '=' + account[key])
          .join('&');

        window.location.href =
          'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/payment?' +
          queryString;
      },
      (errorAccount) => console.log(errorAccount)
    );
  }
}
