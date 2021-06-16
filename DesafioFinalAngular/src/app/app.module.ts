import { AppRoutingModule } from './app-routing.module';
import { ErrorsModule } from './errors/errors.module';
import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { FeaturesModule } from './features/features.module';
import {
  NgbPaginationModule,
  NgbAlertModule,
} from '@ng-bootstrap/ng-bootstrap';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent],
  imports: [
    AppRoutingModule,
    BrowserModule,
    NgbModule,
    FeaturesModule,
    NgbPaginationModule,
    NgbAlertModule,
    HttpClientModule,
    FormsModule,
    ErrorsModule,
    NgxPaginationModule,
  ],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
