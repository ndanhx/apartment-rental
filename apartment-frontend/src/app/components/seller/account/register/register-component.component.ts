import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css'],
})
export class RegisterComponentComponent implements OnInit {
  account: Account = new Account();
  repeatPassword: string;

  constructor(private accountService: AccountService, private router: Router) {}
  ngOnInit(): void {
    this.account.username = localStorage.getItem('username');
    if (this.account.username != null) {
      this.router.navigate(['home']); // home
    }
  }

  onRegister() {
    if (this.repeatPassword == this.account.password) {
      this.accountService.createAccount(this.account).subscribe(
        (data) => {
          this.goToLogin();
          window.alert('Register Successfully.');
        },
        (error) => {
          window.alert('Username Failed.');
          console.log(error);
        }
      );
    } else {
      window.alert('Check Your Repeat Password.');
    }
  }

  goToLogin() {
    this.router.navigate(['login']);
  }
}
