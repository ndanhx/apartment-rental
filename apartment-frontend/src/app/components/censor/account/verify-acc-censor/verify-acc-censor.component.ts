import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject, debounceTime, distinctUntilChanged } from 'rxjs';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-verify-acc-censor',
  templateUrl: './verify-acc-censor.component.html',
  styleUrls: ['./verify-acc-censor.component.css'],
})
export class VerifyAccCensorComponent implements OnInit {
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
    this.getAccountVerified();
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

  private getAccountVerified() {
    this.accountService.getAccountVerified().subscribe((data) => {
      this.accounts = data;
      this.accountFilter = this.accounts;
    });
  }

  unlockAccount(account: Account) {
    this.accountService.unLockAccount(account).subscribe((data) => {
      this.getAccountVerified();
    });
  }
  lockAccount(account: Account) {
    this.accountService.lockAccount(account).subscribe((data) => {
      this.getAccountVerified();
    });
  }
  removeVerifyAccount(account: Account) {
    this.accountService.removeVerifyAccount(account).subscribe((data) => {
      this.getAccountVerified();
    });
  }
  verifyAccount(account: Account) {
    this.accountService.verifyAccount(account).subscribe((data) => {
      this.getAccountVerified();
    });
  }
  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getAccountVerified();
  }
}
