import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent {

  titulo: string = "Bienvenido a AppVentas."

  constructor() { }

  ngOnInit(): void { }

}
