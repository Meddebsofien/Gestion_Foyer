package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Chambre;
import tn.esprit.tic.springproj.Models.Etudiant;
import tn.esprit.tic.springproj.Models.Reservation;
import tn.esprit.tic.springproj.Repository.ChambreRepository;
import tn.esprit.tic.springproj.Repository.EtudiantRepository;
import tn.esprit.tic.springproj.Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements  IReservationService {

    ReservationRepository reservrep;
    ChambreRepository chambreRep;
    EtudiantRepository etudiantRep;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservrep.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservrep.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservrep.getResbyidRes(idReservation);
    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {


        Chambre  chambre = chambreRep.getchambrebynum(numChambre);
        Etudiant etudiant= etudiantRep.getEtudiantbycin(cin);

        String newid = chambreRep.concatnumchambreNomBloc(chambre.getIdChambre()) + etudiant.getCin() ;

        res.setIdReservation(newid);
        Reservation reseravation = reservrep.save(res);


        List<Reservation> listResEt= new ArrayList<>();
        List<Reservation> listResch= new ArrayList<>();

        if(etudiant.getReservationEtudiant()!=null){
            listResEt = etudiant.getReservationEtudiant();
        }
        listResEt.add(reseravation);

        etudiant.setReservationEtudiant(listResEt);
        etudiantRep.save(etudiant);

        if(chambre.getReservationsChambre()!=null){
            listResch=chambre.getReservationsChambre();
        }
        listResch.add(reseravation);
        chambre.setReservationsChambre(listResch);
        chambreRep.save(chambre);
        return reseravation;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        List<Reservation> listAllRes = new ArrayList<>();
        List<Reservation> listRes = new ArrayList<>();
        listAllRes = reservrep.findAll();
        for(int i=0 ; i<listAllRes.size() ; i++){
            if(listAllRes.get(i).getAnneUniv().after(dateDebut) &&  listAllRes.get(i).getAnneUniv().before(dateFin));
            {
                listRes.add(listAllRes.get(i));
            }
        }
        return listRes;
    }
}
