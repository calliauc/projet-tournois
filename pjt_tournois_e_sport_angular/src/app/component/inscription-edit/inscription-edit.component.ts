import { InscriptionService } from './../../service/inscription.service';
import { Inscription } from './../../model/inscription';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-inscription-edit',
  templateUrl: './inscription-edit.component.html',
  styleUrls: ['./inscription-edit.component.css'],
})
export class InscriptionEditComponent implements OnInit {
  inscription: Inscription = new Inscription();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private inscriptionService: InscriptionService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idJoueur&idTournoi']) {
        this.inscriptionService
          .get(params['id.joueur.id'], params['id.tournoi.idTournoi'])
          .subscribe((result) => {
            console.log(result);
            this.inscription = result;
          });
      }
    });
  }

  save() {
    if (
      this.inscription.id?.joueur?.id &&
      this.inscription.id?.tournoi?.idTournoi
    ) {
      this.inscriptionService.update(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    } else {
      this.inscriptionService.create(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    }
  }
}
