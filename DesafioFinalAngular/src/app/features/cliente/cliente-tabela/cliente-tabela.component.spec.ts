import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ClienteTabelaComponent } from './cliente-tabela.component';

describe('ClienteTabelaComponent', () => {
  let component: ClienteTabelaComponent;
  let fixture: ComponentFixture<ClienteTabelaComponent>;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [ClienteTabelaComponent],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteTabelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
