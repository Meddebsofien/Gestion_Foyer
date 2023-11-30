package tn.esprit.tic.springproj.services;

import tn.esprit.tic.springproj.Models.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    Foyer archiverFoyer (long idFoyer);

    Foyer addFoyerWithBloc(Foyer f);
}
