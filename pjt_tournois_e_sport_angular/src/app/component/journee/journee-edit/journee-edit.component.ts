import { JourneeService } from 'src/app/service/journee.service';
import { Journee } from './../../../model/journee';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-journee-edit',
  templateUrl: './journee-edit.component.html',
  styleUrls: ['./journee-edit.component.css'],
})
export class JourneeEditComponent implements OnInit {
  journee: Journee = new Journee();
  constructor(
    private journeeService: JourneeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.journeeService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.journee = result;
        });
      }
    });
  }

  save() {
    if (this.journee.id) {
      this.journeeService.update(this.journee).subscribe((ok) => {
        this.router.navigate(['/journee']);
      });
    } else {
      this.journeeService.create(this.journee).subscribe((ok) => {
        this.router.navigate(['/journee']);
      });
    }
  }

  byId(obj1: Journee, obj2: Journee) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }
}
