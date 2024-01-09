import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';

@Component({
  selector: 'app-add-apartment',
  templateUrl: './add-apartment.component.html',
  styleUrls: ['./add-apartment.component.css'],
})
export class AddApartmentComponent {
  apartment: Apartment = new Apartment();
  constructor(
    private apartmentService: ApartmentService,
    private accountService: AccountService,
    private router: Router,
    private modalService: NgbModal,
    private location: Location
  ) {}

  onSubmit() {
    this.apartment.idAccount = Number(localStorage.getItem('idAccount'));
    this.apartmentService.createApartment(this.apartment).subscribe(
      (data) => {
        window.alert('Added Successfully.');
        this.location.back();
      },
      (error) => {
        window.alert('Server ERROR!!.');
        console.log(error);
      }
    );
  }

  selectedWardId: number;
  onWardSelected(wardId: number) {
    this.selectedWardId = wardId;
    this.apartment.idWard = wardId;
  }
  selectedTypeID: number;
  onTypeSelected(typeID: number) {
    this.selectedTypeID = typeID;
    this.apartment.idType = typeID;
  }
}
