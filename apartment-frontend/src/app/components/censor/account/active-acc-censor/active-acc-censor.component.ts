import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject, debounceTime, distinctUntilChanged } from 'rxjs';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-active-acc-censor',
  templateUrl: './active-acc-censor.component.html',
  styleUrls: ['./active-acc-censor.component.css'],
})
export class ActiveAccCensorComponent implements OnInit {
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
    this.getAccountActive();

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

  private getAccountActive() {
    this.accountService.getAccountActive().subscribe((data) => {
      this.accounts = data;
      this.accountFilter = this.accounts;
    });
  }

  unlockAccount(account: Account) {
    this.accountService.unLockAccount(account).subscribe((data) => {
      this.getAccountActive();
    });
  }
  lockAccount(account: Account) {
    this.accountService.lockAccount(account).subscribe((data) => {
      this.getAccountActive();
    });
  }
  removeVerifyAccount(account: Account) {
    this.accountService.removeVerifyAccount(account).subscribe((data) => {
      this.getAccountActive();
    });
  }
  verifyAccount(account: Account) {
    this.accountService.verifyAccount(account).subscribe((data) => {
      this.getAccountActive();
    });
  }
  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getAccountActive();
  }
}
