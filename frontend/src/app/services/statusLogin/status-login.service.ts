import { Injectable } from '@angular/core';
import { UserService } from '../user/user.service';
import { User } from 'src/app/model/user/user';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusLoginService {

  constructor(private userService: UserService, private router: Router) { }

  public statusLogin = new BehaviorSubject<boolean>(false);
  atributoBooleano$: Observable<boolean> = this.statusLogin.asObservable();
  public userLogin!: User;

  changeStatusLogin() {
    this.statusLogin.next(JSON.parse(localStorage.getItem('loggedIn') ?? 'false'));
  }

  logOut() {
    const userLogin: User = {
      id: 0,
      userCode: '',
      nickName: '',
      email: '',
      password: ''
    };
    this.userService.setUserLogin(userLogin);
    localStorage.setItem('loggedIn', 'false');
    localStorage.removeItem('emailUser');
    this.changeStatusLogin();
    this.router.navigate(['/']);
  }


  login(email:string, password:string) {
    this.userService.getUser(email).subscribe((u: User) => {
      if (u.password === password) {
        localStorage.setItem('loggedIn', 'true');
        this.userLogin = {
          id: u.id,
          userCode: u.userCode,
          nickName: u.nickName,
          email: u.email,
          password: u.password
        };
        localStorage.setItem('emailUser',this.userLogin.email)
        this.userService.setUserLogin(this.userLogin);
        this.changeStatusLogin();
        this.router.navigate(['/']);
      }
    });
  }
}