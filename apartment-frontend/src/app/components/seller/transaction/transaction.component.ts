import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { PaymentReceipt } from 'src/app/model/payment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import { PaymentService } from 'src/app/service/payment.service';
import * as XLSX from 'xlsx';
@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css'],
})
export class TransactionComponent implements OnInit {
  apartments: Apartment[];
  apartment: Apartment = new Apartment();
  accounts: Account[];
  account: Account = new Account();
  payments: PaymentReceipt[] = [];

  constructor(
    private paymentService: PaymentService,
    private accountService: AccountService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getPaymentByIdAccount();
  }
  sumAmountSucess: number = 0;
  private getPaymentByIdAccount() {
    this.account.idAccount = Number(localStorage.getItem('idAccount'));

    this.paymentService
      .getListPaymentByIdAccount(this.account)
      .subscribe((data) => {
        this.payments = data;

        let sum: number = this.payments
          .filter((payment) => payment.status === 1)
          .map((payment) => payment.totalAmount)
          .reduce(function (a, b) {
            return a + b;
          }, 0);
        this.sumAmountSucess = sum;
      });
  }

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getPaymentByIdAccount();
  }

  fileName = 'transaction-list.xlsx';

  exportExcel() {
    let data = document.getElementById('datatable');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(data);

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'sheet1');

    XLSX.writeFile(wb, this.fileName);
  }
}
