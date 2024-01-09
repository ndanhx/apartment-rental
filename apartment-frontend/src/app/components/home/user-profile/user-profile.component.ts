import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import { AddressService } from 'src/app/service/address.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import { TypeService } from 'src/app/service/type.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  account: Account = new Account();
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private apartmentService: ApartmentService,
    private addressService: AddressService,
    private typeService: TypeService,
    private accountService: AccountService
  ) {}
  ngOnInit(): void {
    this.getAccountById();
  }

  getAccountById() {
    this.account.idAccount = Number(localStorage.getItem('idAccount'));
    this.accountService.getAccountById(this.account).subscribe(
      (accountData) => {
        this.account = accountData;
      },
      (errorAccount) => console.log(errorAccount)
    );
  }

  saveChange() {
    console.log(this.account);
    this.accountService.updateAccountButAdmin(this.account).subscribe(
      () => {
        window.alert('Update Information Successfully');
        this.getAccountById();
      },
      (errorAccount) => {
        console.log(errorAccount);
        window.alert('Update Information Failed');
      }
    );
  }

  newPassword: string;
  currentPassword: any;
  renewpassword: string;
  changePassword() {
    if (this.newPassword != this.renewpassword) {
      window.alert('Check your Repassword!');
    } else {
      console.log(this.account);
      this.account.password = this.currentPassword;
      this.accountService.checkLoginAccount(this.account).subscribe(
        (dataAccount) => {
          this.account.password = this.renewpassword;
          this.accountService.changePassword(this.account).subscribe(
            () => {
              window.alert('Change password successfully');
              this.accountService.logout();
              this.router.navigate(['/login']);
            },
            (errorChange) => {
              console.log(errorChange);
              window.alert('Change password Failed');
            }
          );
        },
        (errorAccount) => {
          console.log(errorAccount);
          window.alert('Current Password is failed!');
        }
      );
    }
  }
}
