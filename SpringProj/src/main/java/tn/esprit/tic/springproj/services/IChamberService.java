package tn.esprit.tic.springproj.services;

import tn.esprit.tic.springproj.Models.Chambre;
import tn.esprit.tic.springproj.Models.TypeChambre;

import java.util.List;

public interface IChamberService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);

    public List<Chambre> getChambresParNomBloc( String nomBloc) ;
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc );
}
