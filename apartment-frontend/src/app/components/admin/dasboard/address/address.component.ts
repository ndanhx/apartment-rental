import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { City } from 'src/app/model/city';
import { District } from 'src/app/model/district';
import { Ward } from 'src/app/model/ward';
import { AddressService } from 'src/app/service/address.service';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css'],
})
export class AddressComponent implements OnInit {
  cities: City[];
  districts: District[];
  wards: Ward[];

  city: City;
  district: District = new District();
  ward: Ward = new Ward();

  selectedCity: string = 'Select City';
  selectedDistrict: string = 'Select District';
  selectedWard: string = 'Select Ward';

  constructor(
    private addressService: AddressService,
    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.addressService.getCitiesList().subscribe((data) => {
      this.cities = data;
    });
  }

  onCityChange() {
    this.district.idCity = Number(this.selectedCity);
    this.addressService.getDistrictsByCity(this.district).subscribe((data) => {
      this.districts = data;
    });
  }

  onDistrictChange() {
    this.ward.idDistrict = Number(this.selectedDistrict);
    this.addressService.getWardsByDistrict(this.ward).subscribe((data) => {
      this.wards = data;
    });
  }

  idWardAfterGet: number;
  //truyền dữ liệu component-address  sang component khác
  @Output() wardSelected = new EventEmitter<number>();
  getIdWard() {
    this.idWardAfterGet = Number(this.selectedWard);
    this.wardSelected.emit(this.idWardAfterGet);
  }
}
