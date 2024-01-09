import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import * as moment from 'moment';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css'],
})
export class LoginComponentComponent implements OnInit {
  account: Account = new Account();

  constructor(private accountService: AccountService, private router: Router) {}
  ngOnInit(): void {
    this.account.username = localStorage.getItem('username');
    if (this.account.username != null) {
      this.router.navigate(['home']); // home
    }
  }

  onLogin() {
    console.log(this.account);

    this.accountService.checkLoginAccount(this.account).subscribe(
      (data) => {
        this.account = data;

        const expiresAt = moment().add(100000, 'second');
        localStorage.setItem('username', this.account.username);
        localStorage.setItem('idAccount', this.account.idAccount.toString());
        localStorage.setItem('expires_at', JSON.stringify(expiresAt.valueOf()));

        if (this.account.isActive === 1) {
          if (this.account.role === 0) {
            this.goToAdmin();
          } else if (this.account.role === 1) {
            this.goToSeller();
          } else if (this.account.role === 2) {
            this.goToHome();
          } else if (this.account.role === 3) {
            this.goToCensor();
          }
        } else {
          window.alert(
            'Account is Locked... Contact Duy Anh to Unlock Account'
          );
        }
      },
      (error) => {
        window.alert('Check Your Username and Password!!!');
        console.log(error);
      }
    );
  }

  goToAdmin() {
    this.router.navigate(['index-admin']);
  }

  goToHome() {
    this.router.navigate(['home']); // home
  }
  goToSeller() {
    this.router.navigate(['seller/apartment']);
  }
  goToCensor() {
    this.router.navigate(['']);
  }
}
