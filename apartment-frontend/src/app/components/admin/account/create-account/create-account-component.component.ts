import { Component } from '@angular/core';
import { FormControl, FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-create-account-component',
  templateUrl: './create-account-component.component.html',
  styleUrls: ['./create-account-component.component.css'],
})
export class CreateAccountComponentComponent {
  repassword: string;
  account: Account = new Account();

  constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  onSubmit() {
    // Lấy giá trị của radio button
    if (this.repassword == this.account.password) {
      this.accountService.createAccount(this.account).subscribe(
        (data) => {
          window.alert('Add Account Successfully.');
          this.goToAccountList();
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

  goToAccountList() {
    this.router.navigate(['account']);
  }

  toggleVerify() {
    this.account.verify = this.account.verify === 1 ? 0 : 1;
  }
}
