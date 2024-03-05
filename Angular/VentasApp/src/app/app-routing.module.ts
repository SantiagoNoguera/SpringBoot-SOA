import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductosComponent } from './components/productos/productos.component';
import { VentasComponent } from './components/ventas/ventas.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  //Página que se abrirá por defecto.
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'productos', component: ProductosComponent},
  {path: 'ventas', component: VentasComponent},
  {path: 'usuarios', component: UsuariosComponent},
  {path: 'home', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
