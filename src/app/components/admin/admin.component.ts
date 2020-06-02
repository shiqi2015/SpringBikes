import { Component, OnInit } from '@angular/core';
import { BikeService } from '../../services/bike.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  
  public bikes;

  constructor(private bikesService: BikeService) { }

  ngOnInit(): void {
	this.getBikes();
  }

  getBikes(){
    this.bikesService.getBikes().subscribe(
	    data => { this.bikes = data },
	    err => console.error(err),
	    () => console.log('bikes loaded')
    );
  }

}
