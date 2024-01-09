import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';

@Component({
  selector: 'app-active-apartment',
  templateUrl: './active-apartment.component.html',
  styleUrls: ['./active-apartment.component.css'],
})
export class ActiveApartmentComponent implements OnInit {
  apartments: Apartment[];
  accounts: Account[];

  constructor(
    private apartmentService: ApartmentService,
    private accountService: AccountService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getApartmentListActive();
  }

  private getApartmentListActive() {
    this.apartmentService.getApartmentListActive().subscribe((data) => {
      this.apartments = data;
    });
  }

  deleteApartment(idApartment: number) {
    this.apartmentService.deleteApartment(idApartment).subscribe((data) => {
      this.getApartmentListActive();
    });
  }

  updateApartment(idApartment: number) {
    this.router.navigate(['update-apartment', idApartment]);
  }

  detailApartment(idApartment: number) {
    this.router.navigate(['apartment-detail', idApartment]);
  }

  activeApartment(updateApartment: Apartment) {
    this.apartmentService.activeApartment(updateApartment).subscribe((data) => {
      window.alert('Update Active Successfully');
      this.getApartmentListActive();
    });
  }
  soldApartment(updateApartment: Apartment) {
    this.apartmentService.soldApartment(updateApartment).subscribe((data) => {
      window.alert(
        'Update Sold thành công. Tất cả bài viết liên quan đã được gỡ xuống'
      );
      this.getApartmentListActive();
    });
  }
  acceptListing(apartment: Apartment) {
    this.apartmentService.acceptListing(apartment).subscribe((data) => {
      window.alert('Listing is Posted !!!');
      this.getApartmentListActive();
    });
  }

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getApartmentListActive();
  }

  account: Account = new Account();
  messagePayment: any;
  postApartment(apartment: Apartment) {
    this.account.idAccount = apartment.idAccount;
    this.accountService.getAccountById(this.account).subscribe((data) => {
      this.account = data;
      if (this.account.amount >= 10000) {
        this.apartmentService.postListing(apartment).subscribe((data) => {
          this.messagePayment =
            'This post request was successful posting. ' +
            this.account.username +
            "'s account has been debited 10,000 VND.";
          window.alert(this.messagePayment);
          this.getApartmentListActive();
        });
      } else {
        this.messagePayment =
          this.account.username +
          ', please top up your account to continue posting.';

        window.alert(this.messagePayment);
        this.getApartmentListActive();
      }
    });
  }
}
