import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject, debounceTime, distinctUntilChanged } from 'rxjs';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import * as XLSX from 'xlsx';
@Component({
  selector: 'app-account-manager-component',
  templateUrl: './account-manager-component.component.html',
  styleUrls: ['./account-manager-component.component.css'],
})
export class AccountManagerComponentComponent implements OnInit {
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

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getAccounts();
  }

  fileName = 'account-list.xlsx';

  exportExcel() {
    /**passing table id**/
    let data = document.getElementById('datatable');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(data);

    /**Generate workbook and add the worksheet**/
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'sheet1');

    /*save to file*/
    XLSX.writeFile(wb, this.fileName);
  }
}
