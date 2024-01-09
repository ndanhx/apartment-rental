import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
@Component({
  selector: 'app-check-user-censor',
  templateUrl: './check-user-censor.component.html',
  styleUrls: ['./check-user-censor.component.css'],
})
export class CheckUserCensorComponent implements OnInit {
  account: Account = new Account();
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private accountService: AccountService
  ) {}
  ngOnInit(): void {
    this.account.idAccount = this.route.snapshot.params['idAccount'];
    this.accountService.getAccountById(this.account).subscribe(
      (accountData) => {
        this.account = accountData;
      },
      (errorAccount) => console.log(errorAccount)
    );
  }
  saveChange() {
    console.log(this.account);
  }
}
