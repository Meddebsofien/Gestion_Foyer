package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Etudiant;
import tn.esprit.tic.springproj.Models.Reservation;
import tn.esprit.tic.springproj.Repository.EtudiantRepository;
import tn.esprit.tic.springproj.Repository.ReservationRepository;
import tn.esprit.tic.springproj.services.IEtudiantService;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {

    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepo;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
       return  etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {


        Etudiant etudiant = etudiantRepository.getEtudiantbynomprenom(nomEt,prenomEt);
        Reservation res = reservationRepo.getResbyidRes(idReservation);

        List<Reservation> list = new ArrayList<>();

        if(etudiant.getReservationEtudiant()!=null){
            list = etudiant.getReservationEtudiant();
        }

        list.add(res);
        etudiant.setReservationEtudiant(list);


       etudiantRepository.save(etudiant);

        return etudiant;
    }
}
