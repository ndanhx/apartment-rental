import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  Route,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { Account } from '../model/account';
import { inject } from '@angular/core';
import { AccountService } from '../service/account.service';
import { catchError, map, of } from 'rxjs';

export const sellerGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  let account: Account = new Account();
  const router: Router = inject(Router);
  const accountService: AccountService = inject(AccountService);
  account.username = localStorage.getItem('username') || '';
  return accountService.checkRoleUser(account).pipe(
    map((account: Account) => {
      if (account && account.role === 1) {
        return true;
      } else {
        router.navigate(['']);
        console.log(Error('Unauthorized'));
        return false;
      }
    }),
    catchError((error) => {
      console.log(error);
      return of(false);
    })
  );
};
