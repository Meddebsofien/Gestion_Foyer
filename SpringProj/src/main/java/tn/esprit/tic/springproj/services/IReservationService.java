package tn.esprit.tic.springproj.services;

import tn.esprit.tic.springproj.Models.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);


    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long numChambre, long cin) ;
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin );

}


