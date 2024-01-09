import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';

@Component({
  selector: 'app-result-search',
  templateUrl: './result-search.component.html',
  styleUrls: ['./result-search.component.css'],
})
export class ResultSearchComponent implements OnInit {
  apartments: Apartment[];

  constructor(
    private apartmentService: ApartmentService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getApartmentListPosted();
  }

  private getApartmentListPosted() {
    this.apartmentService.getApartmentListPosted().subscribe((data) => {
      this.apartments = data;
    });
  }

  detailApartment(idApartment: number) {
    this.router.navigate(['apartment-detail', idApartment]);
  }

  showForm: boolean = false;
  nameButton: string = 'filter';
  toggleForm() {
    this.showForm = !this.showForm;
    if (this.showForm === true) {
      this.nameButton = 'Hide';
    } else {
      this.nameButton = 'filter';
    }
  }

  selectedWardId: number = 0;
  onWardSelected(wardId: number) {
    this.selectedWardId = wardId;
    console.log('ward : ', wardId);
  }
  selectedTypeID: number = 0;
  onTypeSelected(typeID: number) {
    this.selectedTypeID = typeID;
    console.log('typeID : ', typeID);
  }

  keyword: any = '  ';
  room: any = 0;
  bathrooms: any = 0;
  minPrice: any = 0;
  searchFilter() {
    const url = this.apartmentService.query(
      this.keyword,
      this.room,
      this.bathrooms,
      this.minPrice,
      this.selectedTypeID,
      this.selectedWardId
    );

    console.log('>>>>>> ', url);
  }
}
