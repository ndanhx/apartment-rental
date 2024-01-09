import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject, debounceTime, distinctUntilChanged } from 'rxjs';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-account-censor',
  templateUrl: './account-censor.component.html',
  styleUrls: ['./account-censor.component.css'],
})
export class AccountCensorComponent implements OnInit {
  accounts: Account[];
  status: string;

  constructor(
    private accountService: AccountService,
    private router: Router,
    private modalService: NgbModal
  ) {}

  inputUsername: string = '';
  inputUsernameControl = new Subject<string>();
  accountFilter = [];

  ngOnInit(): void {
    this.getAccounts();
    this.inputUsernameControl
      .pipe(debounceTime(500), distinctUntilChanged())
      .subscribe((value) => {
        this.inputUsername = value.trim().toLowerCase();
        this.accounts = this.accountFilter.filter((data) =>
          data.username
            .toString()
            .toLocaleLowerCase()
            .includes(this.inputUsername)
        );
        console.log(value);
      });
  }

  private getAccounts() {
    this.accountService.getAccountsList().subscribe((data) => {
      this.accounts = data;
      this.accountFilter = this.accounts;
    });
  }

  updateAccount(idAccount: number) {
    this.router.navigate(['update-account', idAccount]);
  }
  deleteAccount(idAccount: number) {
    this.accountService.deleteAccount(idAccount).subscribe((data) => {
      this.getAccounts();
    });
  }

  unlockAccount(account: Account) {
    this.accountService.unLockAccount(account).subscribe((data) => {
      this.getAccounts();
    });
  }
  lockAccount(account: Account) {
    this.accountService.lockAccount(account).subscribe((data) => {
      this.getAccounts();
    });
  }

  removeVerifyAccount(account: Account) {
    this.accountService.removeVerifyAccount(account).subscribe((data) => {
      this.getAccounts();
    });
  }
  verifyAccount(account: Account) {
    this.accountService.verifyAccount(account).subscribe((data) => {
      this.getAccounts();
    });
  }

  checkUser(idAccount: number) {
    this.router.navigate(['censor/check-user', idAccount]);
  }

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getAccounts();
  }
}
