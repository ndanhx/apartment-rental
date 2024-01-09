import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject, debounceTime, distinctUntilChanged } from 'rxjs';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { PaymentReceipt } from 'src/app/model/payment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import { PaymentService } from 'src/app/service/payment.service';
import { HttpClient } from '@angular/common/http';
import * as XLSX from 'xlsx';
@Component({
  selector: 'app-transaction-admin',
  templateUrl: './transaction-admin.component.html',
  styleUrls: ['./transaction-admin.component.css'],
})
export class TransactionAdminComponent implements OnInit {
  apartments: Apartment[];
  apartment: Apartment = new Apartment();
  accounts: Account[];
  account: Account = new Account();
  payments: PaymentReceipt[] = [];

  constructor(
    private paymentService: PaymentService,
    private accountService: AccountService,
    private http: HttpClient,
    private router: Router,
    private modalService: NgbModal
  ) {}

  startDate: string;
  endDate: string;
  payments2: PaymentReceipt[] = [];
  filteredPayments: PaymentReceipt[] = [];

  onDateChange(): void {
    const start = new Date(this.startDate);
    const end = new Date(this.endDate);
    const formattedStartDate = start.toISOString().slice(0, 10);
    const formattedEndDate = end.toISOString().slice(0, 10);
    const url = this.paymentService.query(formattedStartDate, formattedEndDate);
    this.http.post<PaymentReceipt[]>(url, null).subscribe((data) => {
      this.payments = data;
    });
  }
  ngOnInit(): void {
    this.getPayment();
  }

  sumAmountSucess: number = 0;
  private getPayment() {
    this.paymentService.getListPayment().subscribe((data) => {
      this.payments = data;

      let sum: number = this.payments
        .filter((payment) => payment.status)
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
    this.getPayment();
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
