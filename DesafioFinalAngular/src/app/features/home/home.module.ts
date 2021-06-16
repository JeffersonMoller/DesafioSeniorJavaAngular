import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { PrincipalComponent } from './principal/principal.component';

@NgModule({
  declarations: [ HeaderComponent, PrincipalComponent],
  imports: [CommonModule],
  exports: [ HeaderComponent, PrincipalComponent],
})
export class HomeModule {}
