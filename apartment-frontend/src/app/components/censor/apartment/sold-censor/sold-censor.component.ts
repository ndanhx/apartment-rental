import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';

@Component({
  selector: 'app-sold-censor',
  templateUrl: './sold-censor.component.html',
  styleUrls: ['./sold-censor.component.css'],
})
export class SoldCensorComponent implements OnInit {
  apartments: Apartment[];
  accounts: Account[];

  constructor(
    private apartmentService: ApartmentService,
    private accountService: AccountService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getApartmentListSold();
  }

  private getApartmentListSold() {
    this.apartmentService.getApartmentListSold().subscribe((data) => {
      this.apartments = data;
    });
  }

  deleteApartment(idApartment: number) {
    this.apartmentService.deleteApartment(idApartment).subscribe((data) => {
      this.getApartmentListSold();
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
      this.getApartmentListSold();
    });
  }
  soldApartment(updateApartment: Apartment) {
    this.apartmentService.soldApartment(updateApartment).subscribe((data) => {
      window.alert(
        'Update Sold thành công. Tất cả bài viết liên quan đã được gỡ xuống'
      );
      this.getApartmentListSold();
    });
  }
  acceptListing(apartment: Apartment) {
    this.apartmentService.acceptListing(apartment).subscribe((data) => {
      window.alert('Listing is Posted !!!');
      this.getApartmentListSold();
    });
  }
  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getApartmentListSold();
  }
}
