import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountManagerComponentComponent } from './components/admin/account/list-account/account-manager-component.component';
import { AllApartmentComponentComponent } from './components/admin/apartment/list-apartment/all-apartment-component.component';
import { UpdateAccountComponentComponent } from './components/admin/account/update-account/update-account-component.component';
import { CreateAccountComponentComponent } from './components/admin/account/create-account/create-account-component.component';
import { IndexAdminComponent } from './components/admin/dasboard/index-admin/index-admin.component';
import { AddApartmentComponent } from './components/admin/apartment/add-apartment/add-apartment.component';
import { adminGuard } from './guard/admin.guard';
import { ApartmentDetailComponent } from './components/home/apartment-detail/apartment-detail.component';
import { UpdateApartmentComponent } from './components/admin/apartment/update-apartment/update-apartment.component';
import { ListTypeComponent } from './components/admin/apartment-type/list-type/list-type.component';
import { PendingApartmentComponent } from './components/admin/apartment/pending-apartment/pending-apartment.component';
import { LockedComponent } from './components/admin/account/locked/locked.component';
import { ActiveComponent } from './components/admin/account/active/active.component';
import { VerifiedComponent } from './components/admin/account/verified/verified.component';
import { LoginComponentComponent } from './components/seller/account/login/login-component.component';
import { RegisterComponentComponent } from './components/seller/account/register/register-component.component';
import { ApartmentSellerComponent } from './components/seller/apartment/apartment-seller/apartment-seller.component';
import { sellerGuard } from './guard/seller.guard';
import { PostedApartmentComponent } from './components/admin/apartment/posted-apartment/posted-apartment.component';
import { UpdateSellerComponent } from './components/seller/apartment/update-seller/update-seller.component';
import { PostedSellerComponent } from './components/seller/apartment/posted-seller/posted-seller.component';
import { PendingSellerComponent } from './components/seller/apartment/pending-seller/pending-seller.component';
import { SoldApartmentComponent } from './components/admin/apartment/sold-apartment/sold-apartment.component';
import { SoldSellerComponent } from './components/seller/apartment/sold-seller/sold-seller.component';
import { ActiveApartmentComponent } from './components/admin/apartment/active-apartment/active-apartment.component';
import { UserProfileComponent } from './components/home/user-profile/user-profile.component';
import { ApartmentCensorComponent } from './components/censor/apartment/apartment-censor/apartment-censor.component';
import { censorGuard } from './guard/censor.guard';
import { SoldCensorComponent } from './components/censor/apartment/sold-censor/sold-censor.component';
import { PendingCensorComponent } from './components/censor/apartment/pending-censor/pending-censor.component';
import { PostedCensorComponent } from './components/censor/apartment/posted-censor/posted-censor.component';
import { AccountCensorComponent } from './components/censor/account/account-censor/account-censor.component';
import { VerifyAccCensorComponent } from './components/censor/account/verify-acc-censor/verify-acc-censor.component';
import { LockAccCensorComponent } from './components/censor/account/lock-acc-censor/lock-acc-censor.component';
import { ActiveAccCensorComponent } from './components/censor/account/active-acc-censor/active-acc-censor.component';
import { CheckUserCensorComponent } from './components/censor/account/check-user-censor/check-user-censor.component';
import { HomeComponentComponent } from './components/home/home/home-component.component';
import { TransactionComponent } from './components/seller/transaction/transaction.component';
import { TransactionAdminComponent } from './components/admin/transaction-admin/transaction-admin.component';

const routes: Routes = [
  { path: '', component: HomeComponentComponent },
  { path: 'login', component: LoginComponentComponent },
  {
    path: 'account',
    component: AccountManagerComponentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'account/locked',
    component: LockedComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'account/active',
    component: ActiveComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'account/verified',
    component: VerifiedComponent,
    canActivate: [adminGuard],
  },

  { path: 'register', component: RegisterComponentComponent },

  {
    path: 'account/create',
    component: CreateAccountComponentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'update-account/:idAccount',
    component: UpdateAccountComponentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'apartment',
    component: AllApartmentComponentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'apartment/create',
    component: AddApartmentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'seller/apartment/create',
    component: AddApartmentComponent,
    canActivate: [sellerGuard],
  },
  {
    path: 'update-apartment/:idApartment',
    component: UpdateApartmentComponent,
  },

  {
    path: 'apartment-detail/:idApartment',
    component: ApartmentDetailComponent,
  },
  {
    path: 'apartment/pending',
    component: PendingApartmentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'apartment/posted',
    component: PostedApartmentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'apartment/active',
    component: ActiveApartmentComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'apartment/sold-out',
    component: SoldApartmentComponent,
    canActivate: [adminGuard],
  },

  {
    path: 'type',
    component: ListTypeComponent,
    canActivate: [adminGuard],
  },

  {
    path: 'payment/all',
    component: TransactionAdminComponent,
    canActivate: [adminGuard],
  },
  //SELLER
  {
    path: 'seller/apartment',
    component: ApartmentSellerComponent,
    canActivate: [sellerGuard],
  },

  {
    path: 'seller/apartment/posted',
    component: PostedSellerComponent,
    canActivate: [sellerGuard],
  },
  {
    path: 'seller/apartment/pending',
    component: PendingSellerComponent,
    canActivate: [sellerGuard],
  },

  {
    path: 'seller/update-apartment/:idApartment',
    component: UpdateSellerComponent,
    canActivate: [sellerGuard],
  },
  {
    path: 'seller/apartment/sold',
    component: SoldSellerComponent,
    canActivate: [sellerGuard],
  },
  {
    path: 'seller/transaction',
    component: TransactionComponent,
    canActivate: [sellerGuard],
  },
  //CENSOR-kiem duyet vien
  {
    path: 'censor/apartment',
    component: ApartmentCensorComponent,
    canActivate: [censorGuard],
  },

  {
    path: 'censor/apartment/sold-out',
    component: SoldCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/apartment/pending',
    component: PendingCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/apartment/posted',
    component: PostedCensorComponent,
    canActivate: [censorGuard],
  },

  {
    path: 'censor/account',
    component: AccountCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/account/verified',
    component: VerifyAccCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/account/locked',
    component: LockAccCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/account/active',
    component: ActiveAccCensorComponent,
    canActivate: [censorGuard],
  },
  {
    path: 'censor/check-user/:idAccount',
    component: CheckUserCensorComponent,
  },

  //HOME
  { path: 'home', redirectTo: '', pathMatch: 'full' },
  { path: 'index', redirectTo: '', pathMatch: 'full' },
  {
    path: 'index-admin',
    component: IndexAdminComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'seller/profile',
    component: UserProfileComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
