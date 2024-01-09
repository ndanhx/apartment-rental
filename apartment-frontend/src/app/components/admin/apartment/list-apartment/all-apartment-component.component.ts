import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';

@Component({
  selector: 'app-all-apartment-component',
  templateUrl: './all-apartment-component.component.html',
  styleUrls: ['./all-apartment-component.component.css'],
})
export class AllApartmentComponentComponent implements OnInit {
  apartments: Apartment[];
  accounts: Account[];
  account: Account = new Account();

  constructor(
    private apartmentService: ApartmentService,
    private accountService: AccountService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getApartmentList();
  }

  private getApartmentList() {
    this.apartmentService.getApartmentList().subscribe((data) => {
      this.apartments = data;
    });
  }

  deleteApartment(idApartment: number) {
    this.apartmentService.deleteApartment(idApartment).subscribe((data) => {
      this.getApartmentList();
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
      this.getApartmentList();
    });
  }
  soldApartment(updateApartment: Apartment) {
    this.apartmentService.soldApartment(updateApartment).subscribe((data) => {
      window.alert(
        'Update Sold successful. All related posts have been removed.'
      );
      this.getApartmentList();
    });
  }

  acceptListing(apartment: Apartment) {
    this.apartmentService.acceptListing(apartment).subscribe((data) => {
      window.alert('Posted successfully !');
      this.getApartmentList();
    });
  }
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
          this.getApartmentList();
        });
      } else {
        this.messagePayment =
          this.account.username +
          ', please top up your account to continue posting.';

        window.alert(this.messagePayment);
        this.getApartmentList();
      }
    });
  }

  rejectListing(apartment: Apartment) {
    this.account.idAccount = apartment.idAccount;
    this.accountService.getAccountById(this.account).subscribe((data) => {
      this.account = data;
      //reject and refund
      this.apartmentService.rejectListing(apartment).subscribe((data) => {
        this.messagePayment =
          'This post request was REJECT posting. ' +
          this.account.username +
          "'s account has been refunded 10,000 VND.";
        window.alert(this.messagePayment);
        this.getApartmentList();
      });

      this.getApartmentList();
    });
  }

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getApartmentList();
  }
}
