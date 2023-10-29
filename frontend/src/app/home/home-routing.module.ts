import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './home.page';
import { AppListComponent } from '../components/app-list/app-list.component';
import { BookListComponent } from '../components/book-list/book-list/book-list.component';

const routes: Routes = [
  {
    path: '',
    component: HomePage,
    children: [
      {
        path: '',
        component: AppListComponent
      },
      {
        path: 'books',
        component:BookListComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomePageRoutingModule { }
