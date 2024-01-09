import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponentComponent } from './components/seller/account/login/login-component.component';
import { AccountManagerComponentComponent } from './components/admin/account/list-account/account-manager-component.component';
import { NavigateManagerComponentComponent } from './components/admin/dasboard/navigate-admin/navigate-manager-component.component';
import { HeaderComponentComponent } from './components/admin/dasboard/header/header-component.component';
import { RegisterComponentComponent } from './components/seller/account/register/register-component.component';
import { AllApartmentComponentComponent } from './components/admin/apartment/list-apartment/all-apartment-component.component';
import { UpdateAccountComponentComponent } from './components/admin/account/update-account/update-account-component.component';
import { CreateAccountComponentComponent } from './components/admin/account/create-account/create-account-component.component';
import { AddApartmentComponent } from './components/admin/apartment/add-apartment/add-apartment.component';
import { UpdateApartmentComponent } from './components/admin/apartment/update-apartment/update-apartment.component';
import { IndexAdminComponent } from './components/admin/dasboard/index-admin/index-admin.component';
import { AddressComponent } from './components/admin/dasboard/address/address.component';
import { HeaderComponent } from './components/home/header/header.component';
import { FooterComponent } from './components/home/footer/footer.component';
import { ApartmentDetailComponent } from './components/home/apartment-detail/apartment-detail.component';
import { ListTypeComponent } from './components/admin/apartment-type/list-type/list-type.component';
import { AddTypeComponent } from './components/admin/apartment-type/add-type/add-type.component';
import { PendingApartmentComponent } from './components/admin/apartment/pending-apartment/pending-apartment.component';
import { PostedApartmentComponent } from './components/admin/apartment/posted-apartment/posted-apartment.component';
import { LockedComponent } from './components/admin/account/locked/locked.component';
import { ActiveComponent } from './components/admin/account/active/active.component';
import { VerifiedComponent } from './components/admin/account/verified/verified.component';
import { TypeComponent } from './components/admin/dasboard/type/type.component';
import { NavComponent } from './components/seller/nav/nav.component';
import { ApartmentSellerComponent } from './components/seller/apartment/apartment-seller/apartment-seller.component';
import { PostedSellerComponent } from './components/seller/apartment/posted-seller/posted-seller.component';
import { UpdateSellerComponent } from './components/seller/apartment/update-seller/update-seller.component';
import { PendingSellerComponent } from './components/seller/apartment/pending-seller/pending-seller.component';
import { SoldApartmentComponent } from './components/admin/apartment/sold-apartment/sold-apartment.component';
import { SoldSellerComponent } from './components/seller/apartment/sold-seller/sold-seller.component';
import { ActiveApartmentComponent } from './components/admin/apartment/active-apartment/active-apartment.component';
import { AmountFormatPipe } from './pipe/amount-format.pipe';
import { UserProfileComponent } from './components/home/user-profile/user-profile.component';
import { NavCensorComponent } from './components/censor/nav-censor/nav-censor.component';
import { ApartmentCensorComponent } from './components/censor/apartment/apartment-censor/apartment-censor.component';
import { PendingCensorComponent } from './components/censor/apartment/pending-censor/pending-censor.component';
import { PostedCensorComponent } from './components/censor/apartment/posted-censor/posted-censor.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AccountCensorComponent } from './components/censor/account/account-censor/account-censor.component';
import { VerifyAccCensorComponent } from './components/censor/account/verify-acc-censor/verify-acc-censor.component';
import { ActiveAccCensorComponent } from './components/censor/account/active-acc-censor/active-acc-censor.component';
import { LockAccCensorComponent } from './components/censor/account/lock-acc-censor/lock-acc-censor.component';
import { SoldCensorComponent } from './components/censor/apartment/sold-censor/sold-censor.component';
import { CheckUserCensorComponent } from './components/censor/account/check-user-censor/check-user-censor.component';
import { ResultSearchComponent } from './components/home/result-search/result-search.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { NgxSpinnerModule } from 'ngx-spinner';
import { HomeComponentComponent } from './components/home/home/home-component.component';
import { TransactionComponent } from './components/seller/transaction/transaction.component';
import { TransactionAdminComponent } from './components/admin/transaction-admin/transaction-admin.component';
import { ShorAmountPipe } from './pipe/shor-amount.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    HomeComponentComponent,
    AccountManagerComponentComponent,
    NavigateManagerComponentComponent,
    HeaderComponentComponent,
    RegisterComponentComponent,
    AllApartmentComponentComponent,
    UpdateAccountComponentComponent,
    CreateAccountComponentComponent,
    AddApartmentComponent,
    UpdateApartmentComponent,
    IndexAdminComponent,
    AddressComponent,
    HeaderComponent,
    FooterComponent,
    ApartmentDetailComponent,
    HomeComponentComponent,
    ListTypeComponent,
    AddTypeComponent,
    PendingApartmentComponent,
    PostedApartmentComponent,
    LockedComponent,
    ActiveComponent,
    VerifiedComponent,
    TypeComponent,
    NavComponent,
    ApartmentSellerComponent,
    PostedSellerComponent,
    UpdateSellerComponent,
    PendingSellerComponent,
    SoldApartmentComponent,
    SoldSellerComponent,
    ActiveApartmentComponent,
    AmountFormatPipe,
    UserProfileComponent,
    NavCensorComponent,
    ApartmentCensorComponent,
    PendingCensorComponent,
    PostedCensorComponent,
    SoldCensorComponent,
    AccountCensorComponent,
    VerifyAccCensorComponent,
    ActiveAccCensorComponent,
    LockAccCensorComponent,
    CheckUserCensorComponent,
    ResultSearchComponent,
    TransactionComponent,
    TransactionAdminComponent,
    ShorAmountPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    InfiniteScrollModule,
    NgxSpinnerModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
