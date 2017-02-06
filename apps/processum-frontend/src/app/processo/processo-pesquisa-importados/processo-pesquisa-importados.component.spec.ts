/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ProcessoPesquisaImportadosComponent } from './processo-pesquisa-importados.component';

describe('ProcessoPesquisaImportadosComponent', () => {
  let component: ProcessoPesquisaImportadosComponent;
  let fixture: ComponentFixture<ProcessoPesquisaImportadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoPesquisaImportadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoPesquisaImportadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
