import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AppListComponent } from './components/app-list/app-list.component';
import { BookListComponent } from './components/book-list/book-list/book-list.component';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    loadChildren: () => import('./page/auth/auth.module').then(m => m.AuthPageModule)
  },
  {
    path: 'change-password',
    loadChildren: () => import('./page/changePassword/change-password/change-password.module').then(m => m.ChangePasswordPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
