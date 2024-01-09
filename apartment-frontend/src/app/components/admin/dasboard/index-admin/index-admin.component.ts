import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Account } from 'src/app/model/account';
import { PaymentReceipt } from 'src/app/model/payment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import { PaymentService } from 'src/app/service/payment.service';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Apartment } from 'src/app/model/apartment';

@Component({
  selector: 'app-index-admin',
  templateUrl: './index-admin.component.html',
  styleUrls: ['./index-admin.component.css'],
})
export class IndexAdminComponent implements OnInit {
  totalAccountThisYear: number;
  accounts: Account[];
  status: string;
  payments: PaymentReceipt[] = [];
  apartments: Apartment[] = [];
  constructor(
    private accountService: AccountService,
    private apartmentsService: ApartmentService,
    private paymentService: PaymentService,
    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getTotalAccountThisYear();
    this.getTotalListingToday();
    this.getPaymentToday();
    this.getListingTop5();
    this.getTotalAmountThisMonth();
  }

  getTotalAccountThisYear() {
    this.accountService.totalAccountThisYear().subscribe((data) => {
      this.totalAccountThisYear = data;
    });
  }
  totalListingToday: number = 0;
  getTotalListingToday() {
    this.apartmentsService.totalListingToday().subscribe((data) => {
      this.totalListingToday = data;
    });
  }

  totalAmountThisMonth: number = 0;
  getTotalAmountThisMonth() {
    this.paymentService.getTotalThisMonth().subscribe((data) => {
      this.totalAmountThisMonth = data;
    });
  }

  private getPaymentToday() {
    this.paymentService.getListPaymentToday().subscribe((data) => {
      this.payments = data;
    });
  }
  getAllAccount() {
    this.accountService.getAccountsList().subscribe((data) => {
      this.accounts = data;
    });
  }

  getListingTop5() {
    this.apartmentsService.getApartmentListTop5Favorite().subscribe((data) => {
      this.apartments = data;
    });
  }
  detailApartment(idApartment: number) {
    this.router.navigate(['apartment-detail', idApartment]);
  }
}
