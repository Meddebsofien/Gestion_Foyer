package tn.esprit.tic.springproj.services;

import tn.esprit.tic.springproj.Models.Bloc;

import java.util.List;

public interface IBlocService  {

    List<Bloc> retrieveBlocs();

Bloc updateBloc (Bloc bloc);

Bloc addBloc (Bloc bloc);

Bloc retrieveBloc (long idBloc);

void archiverBloc (long idBloc);

   public Bloc affecterChambresABloc (List<Long> numChambre, String nomBloc) ;
}
