/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ProcessoPesquisaSolicitadosComponent } from './processo-pesquisa-solicitados.component';

describe('ProcessoPesquisaSolicitadosComponent', () => {
  let component: ProcessoPesquisaSolicitadosComponent;
  let fixture: ComponentFixture<ProcessoPesquisaSolicitadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoPesquisaSolicitadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoPesquisaSolicitadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
