import { InscriptionService } from './../../service/inscription.service';
import { Inscription } from './../../model/inscription';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-inscription-edit',
  templateUrl: './inscription-edit.component.html',
  styleUrls: ['./inscription-edit.component.css'],
})
export class InscriptionEditComponent implements OnInit {
  inscription: Inscription = new Inscription();
  creation: boolean = true;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private inscriptionService: InscriptionService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idJoueur'] && params['idTournoi']) {
        this.creation = false;
        this.inscriptionService
          .get(params['idJoueur'], params['idTournoi'])
          .subscribe((result) => {
            this.inscription = result;
          });
      }
    });
  }

  save() {
    if (!this.creation) {
      this.inscriptionService.update(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    } else {
      this.inscriptionService.create(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    }
    this.creation = true;
  }
}
