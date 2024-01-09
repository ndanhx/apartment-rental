import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { ApartmentType } from 'src/app/model/type';
import { Ward } from 'src/app/model/ward';
import { AccountService } from 'src/app/service/account.service';
import { AddressService } from 'src/app/service/address.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import { TypeService } from 'src/app/service/type.service';

@Component({
  selector: 'app-apartment-detail',
  templateUrl: './apartment-detail.component.html',
  styleUrls: ['./apartment-detail.component.css'],
})
export class ApartmentDetailComponent implements OnInit {
  apartment: Apartment = new Apartment();

  address: any;
  ward: Ward = new Ward();
  type: ApartmentType = new ApartmentType();
  account: Account = new Account();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private apartmentService: ApartmentService,
    private addressService: AddressService,
    private typeService: TypeService,
    private accountService: AccountService
  ) {}
  ngOnInit(): void {
    this.apartment.idApartment = this.route.snapshot.params['idApartment'];

    //getApartmentById
    this.apartmentService.getApartmentById(this.apartment).subscribe(
      (data) => {
        this.apartment = data;
        //getaddress
        this.ward.idWard = this.apartment.idWard;
        this.addressService.getAddressByIDWard(this.ward).subscribe(
          (dataAddress) => {
            this.address = dataAddress;
          },
          (errorAddress) => console.log(errorAddress)
        );
        // end getaddress

        //type
        this.type.idType = this.apartment.idType;
        this.typeService.getTypeByID(this.type).subscribe(
          (typeData) => {
            this.type = typeData;
          },
          (errorType) => console.log(errorType)
        );
        //end type

        //account
        this.account.idAccount = this.apartment.idAccount;
        this.accountService.getAccountById(this.account).subscribe(
          (accountData) => {
            this.account = accountData;
          },
          (errorAccount) => console.log(errorAccount)
        );
        //end account

        //update heart
        this.apartmentService.updateHeart(this.apartment).subscribe(
          (heartData) => {
            console.log('da +1 tim cho id: ', this.apartment.idApartment);
          },
          (heartError) => console.log(heartError)
        );
      },
      (error) => console.log(error)
    );
    //end  getApartmentById
  }
}
