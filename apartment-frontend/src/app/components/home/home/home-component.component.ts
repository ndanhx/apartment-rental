import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Apartment } from 'src/app/model/apartment';
import { ApartmentService } from 'src/app/service/apartment.service';
import { HttpClient } from '@angular/common/http';
import { NgxSpinnerService } from 'ngx-spinner';
import { ApartmentType } from 'src/app/model/type';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css'],
})
export class HomeComponentComponent implements OnInit {
  apartments: Apartment[];
  showForm: boolean = false;
  nameButton: string = 'filter';
  apartmentType: ApartmentType = new ApartmentType();
  selectedTypeID: number = 0;
  selectedWardId: number = 0;

  keyword: any;
  room: any;
  bathrooms: any;
  minPrice: any;

  constructor(
    private apartmentService: ApartmentService,

    private router: Router,
    private http: HttpClient,
    private spinner: NgxSpinnerService
  ) {}

  ngOnInit(): void {
    this.getApartmentListPostedLimit6();
    this.checkApartmentValid();
  }

  private getApartmentListPosted() {
    this.apartmentService.getApartmentListPosted().subscribe((data) => {
      this.apartments = data;
    });
  }

  detailApartment(idApartment: number) {
    this.router.navigate(['apartment-detail', idApartment]);
  }

  toggleForm() {
    this.showForm = !this.showForm;
    if (this.showForm === true) {
      this.nameButton = 'Hide';
    } else {
      this.nameButton = 'filter';
    }
  }

  onWardSelected(wardId: number) {
    this.selectedWardId = wardId;
    console.log('ward : ', wardId);
  }

  onTypeSelected(typeID: number) {
    this.selectedTypeID = typeID;
    console.log('typeID : ', typeID);
  }

  onTypeSelected2(typeID: number) {
    console.log('typeID : ', typeID);
    this.apartmentType.idType = typeID;
    this.apartmentService
      .getApartmentOfType(this.apartmentType)
      .subscribe((dataOfType) => {
        this.apartments = dataOfType;
      });
  }

  searchFilter() {
    const url = this.apartmentService.query(
      this.keyword,
      this.room,
      this.bathrooms,
      this.minPrice,
      this.selectedTypeID,
      this.selectedWardId
    );
    this.http.get<Apartment[]>(url).subscribe((data) => {
      this.apartments = data;
      this.showForm = false;
      this.nameButton = 'filter';
    });
  }

  checkApartmentValid() {
    this.apartmentService.checkApartmentValid().subscribe((data) => {
      console.log('da xoa mot so bai dang qua han');
    });
  }
  page: number = 1;
  count: number = 0;
  tableSize: number = 6;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getApartmentListPosted();
  }

  notScrolly = true;
  isEmptyApartment = true;

  lenght: number = 0;

  onScroll() {
    this.lenght = this.apartments.length;
    this.apartmentService
      .getApartmentListPostedLimit3Continue(this.lenght)
      .subscribe((data) => {
        if (data.length === 0) {
          this.isEmptyApartment = false;
        }
        this.apartments = this.apartments.concat(data);
      });
  }

  private getApartmentListPostedLimit6() {
    this.apartmentService.getApartmentListPostedLimit6().subscribe((data) => {
      this.apartments = data;
    });
  }
}
