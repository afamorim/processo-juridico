import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'loading-indicator',
  templateUrl: './loading-indicator.component.html',
  styleUrls: ['./loading-indicator.component.css']
})
export class LoadingIndicatorComponent implements OnInit {
  
  private visible:boolean = false;

  constructor() { }

  ngOnInit() {
  }

  public show():void {
    this.visible = true;
  }

  public hide():void {
    this.visible = false;
  }

}
