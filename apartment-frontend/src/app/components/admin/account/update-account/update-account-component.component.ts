import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-update-account-component',
  templateUrl: './update-account-component.component.html',
  styleUrls: ['./update-account-component.component.css'],
})
export class UpdateAccountComponentComponent implements OnInit {
  idAccount: number;
  account: Account = new Account();

  constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idAccount = this.route.snapshot.params['idAccount'];
    this.account.idAccount = this.idAccount;
    this.accountService.getAccountById(this.account).subscribe(
      (data) => {
        this.account = data;
      },
      (error) => console.log(error)
    );
  }
  onSubmit() {
    this.accountService.updateAccount(this.account).subscribe(
      (data) => {
        this.goToAccountList();
      },
      (error) => console.log(error)
    );
  }

  goToAccountList() {
    this.router.navigate(['account']);
  }

  updateRole(roleValue: number) {
    this.account.role = roleValue;
  }

  toggleVerify() {
    this.account.verify = this.account.verify === 1 ? 0 : 1;
  }
}
