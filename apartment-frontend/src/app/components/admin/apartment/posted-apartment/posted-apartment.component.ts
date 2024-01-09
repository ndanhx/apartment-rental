import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'src/app/model/account';
import { Apartment } from 'src/app/model/apartment';
import { AccountService } from 'src/app/service/account.service';
import { ApartmentService } from 'src/app/service/apartment.service';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-posted-apartment',
  templateUrl: './posted-apartment.component.html',
  styleUrls: ['./posted-apartment.component.css'],
})
export class PostedApartmentComponent implements OnInit {
  apartments: Apartment[];
  accounts: Account[];

  constructor(
    private apartmentService: ApartmentService,
    private accountService: AccountService,

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

  deleteApartment(idApartment: number) {
    this.apartmentService.deleteApartment(idApartment).subscribe((data) => {
      this.getApartmentListPosted();
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
      this.getApartmentListPosted();
    });
  }
  soldApartment(updateApartment: Apartment) {
    this.apartmentService.soldApartment(updateApartment).subscribe((data) => {
      window.alert(
        'Update Sold successfully. All related listings have been removed.'
      );
      this.getApartmentListPosted();
    });
  }
  deleteListing(updateApartment: Apartment) {
    this.apartmentService.soldApartment(updateApartment).subscribe((data) => {
      window.alert('The listing has been removed!');
      this.getApartmentListPosted();
    });
  }
  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  onTableDataChange(event: any): void {
    this.page = event;
    this.getApartmentListPosted();
  }

  fileName = 'apartment-posted-list.xlsx';
  exportExcel() {
    /**passing table id**/
    let data = document.getElementById('datatable');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(data);

    /**Generate workbook and add the worksheet**/
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'sheet1');

    /*save to file*/
    XLSX.writeFile(wb, this.fileName);
  }
}
