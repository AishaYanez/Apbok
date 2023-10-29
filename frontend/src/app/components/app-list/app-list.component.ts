import { Component, OnInit } from '@angular/core';
import { App } from 'src/app/model/app/app';
import { AppService } from 'src/app/services/app/app.service';
import { AppsGalleryService } from 'src/app/services/appsGallery/apps-gallery.service';
import { UserService } from 'src/app/services/user/user.service';


@Component({
  selector: 'app-app-list',
  templateUrl: './app-list.component.html',
  styleUrls: ['./app-list.component.scss'],
})
export class AppListComponent implements OnInit {
  public id: number = 0;
  public apps: Array<App> = [];
  public name!: string;
  public description!: string;
  public price!: number;
  public edit: boolean = false;

  constructor(private appService: AppService, private appGaService: AppsGalleryService, private userService: UserService) { }

  ngOnInit(): void {
    this.getAllApps();
  }

  getAllApps() {
    this.appService.getApps().subscribe((apps: Array<App>) => {
      this.apps = apps;
    });
  }

  addApp() {
    let app = {
      id: 0,
      img: '',
      name: this.name,
      description: this.description || 'Sin descripción',
      price: this.price
    };

    this.appService.postApp(app).subscribe((r) => {
      console.log('Se ha añadido correctamente');
      this.getAllApps();
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
      }
    )
  }

  updateApp(app: App) {
    this.id = app.id;
    this.name = app.name;
    this.description = app.description;
    this.price = app.price;
    this.edit = true;
  }

  putApp() {
    let app = {
      id: 0,
      img: '',
      name: this.name,
      description: this.description,
      price: this.price
    };

    this.appService.updateApp(this.id, app).subscribe((r) => {
      console.log('Se ha actualizado correctamente');
      this.getAllApps();
      this.edit = false;
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
      }
    )
  }

  deleteApp(id: number) {
    this.appService.deleteApp(id).subscribe((r) => {
      console.log('Se ha eliminiado correctamente');
      this.getAllApps();
      this.edit = false;
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
      }
    )
  }

  // buyApp(app: App) {
  //   this.userService.getUser(localStorage.getItem('emailUser') ?? '').subscribe((u) => {
  //     this.appGaService.postNewApp(app, u).subscribe((r) => { console.log('Respuesta del servidor:', r); },
  //       (error) => { console.lzeog('Error al realizar la solicitud: ', error); })
  //   }
  //   );
  // }
}
