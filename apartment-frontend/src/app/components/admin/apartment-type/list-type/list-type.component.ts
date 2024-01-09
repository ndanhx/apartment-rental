import { Type } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ApartmentType } from 'src/app/model/type';
import { TypeService } from 'src/app/service/type.service';

@Component({
  selector: 'app-list-type',
  templateUrl: './list-type.component.html',
  styleUrls: ['./list-type.component.css'],
})
export class ListTypeComponent implements OnInit {
  types: ApartmentType[];
  addType: ApartmentType = new ApartmentType();
  constructor(
    private typeService: TypeService,

    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getTypeList();
  }

  private getTypeList() {
    this.typeService.getAllTypes().subscribe((data) => {
      this.types = data;
    });
  }

  edit(type: ApartmentType) {
    console.log(type);
  }

  onSubmit() {}

  openModal() {
    const createModal = document.getElementById('createTypeModal');
    if (createModal != null) {
      createModal.style.display = 'block';
    }
  }
  closeModal() {
    const createModal = document.getElementById('createTypeModal');
    if (createModal != null) {
      createModal.style.display = 'none';
    }
  }

  onsubmitCreate() {
    this.typeService.createType(this.addType).subscribe(
      (data) => {
        const createModal = document.getElementById('createTypeModal');
        if (createModal != null) {
          createModal.style.display = 'none';
        }
        this.getTypeList();
      },
      (error) => {
        window.alert('Failed.');
        console.log(error);
      }
    );
    this.addType = new ApartmentType();
  }
  deteleType(idType: number) {
    this.typeService.deleteType(idType).subscribe(
      (data) => {
        const createModal = document.getElementById('createTypeModal');
        if (createModal != null) {
          createModal.style.display = 'none';
        }
        this.getTypeList();
      },
      (error) => {
        window.alert('Failed.');
        console.log(error);
      }
    );
  }
}
