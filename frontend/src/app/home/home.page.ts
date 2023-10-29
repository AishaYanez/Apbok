import { Component, OnInit } from '@angular/core';
import { AppService } from '../services/app/app.service';
import { App } from '../model/app/app';
import { Router } from '@angular/router';
import { StatusLoginService } from '../services/statusLogin/status-login.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  public apps: Array<App> = [];
  public myApp!: App;

  constructor(private statusService:StatusLoginService) { }
  ngOnInit(): void { }

  ionViewWillEnter(): void {
    this.statusService.changeStatusLogin();
  }
}
