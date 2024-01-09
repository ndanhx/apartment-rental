import { Type } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ApartmentType } from 'src/app/model/type';
import { TypeService } from 'src/app/service/type.service';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.css'],
})
export class TypeComponent implements OnInit {
  types: ApartmentType[];
  type: ApartmentType;
  selectedIdType: number;

  constructor(private typeService: TypeService) {}

  ngOnInit(): void {
    this.getTypeList();
  }

  private getTypeList() {
    this.typeService.getAllTypes().subscribe((data) => {
      this.types = data;
    });
  }

  idTypeAfterGet: number;
  //truyền dữ liệu component-address  sang component khác
  @Output() typeSelected = new EventEmitter<number>();
  getIdType() {
    this.idTypeAfterGet = this.selectedIdType;
    this.typeSelected.emit(this.idTypeAfterGet);
  }
}
