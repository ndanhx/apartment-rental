import * as moment from 'moment';
import { Account } from '../model/account';
import { AccountService } from '../service/account.service';
import { inject } from '@angular/core';
import { catchError, map, of } from 'rxjs';
import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

export const censorGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  let account: Account = new Account();
  const router: Router = inject(Router);
  const accountService: AccountService = inject(AccountService);
  account.username = localStorage.getItem('username') || '';
  return accountService.checkRoleUser(account).pipe(
    map((account: Account) => {
      if (account && account.role === 3) {
        return true;
      } else {
        console.log(Error('Unauthorized'));
        router.navigate(['home']);
        return false;
      }
    }),
    catchError((error) => {
      console.log(error);
      router.navigate(['home']);
      return of(false);
    })
  );
};
