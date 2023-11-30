package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Bloc;
import tn.esprit.tic.springproj.Models.Chambre;
import tn.esprit.tic.springproj.Models.Reservation;
import tn.esprit.tic.springproj.Models.TypeChambre;
import tn.esprit.tic.springproj.Repository.BlocRepository;
import tn.esprit.tic.springproj.Repository.ChambreRepository;
import tn.esprit.tic.springproj.Repository.ReservationRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static tn.esprit.tic.springproj.Models.TypeChambre.*;

@Service
@AllArgsConstructor
@Slf4j
public class ChamberService implements  IChamberService {


    ChambreRepository chambrerep;
    BlocRepository blocrep;
    IBlocService bs;
    ReservationRepository resRep;



    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambrerep.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambrerep.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambrerep.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambrerep.findById(idChambre).get();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc = blocrep.getblocbyNom(nomBloc);
        if (bloc == null) {
            log.info("Le bloc avec le nom spécifié n'a pas été trouvé.");
            return Collections.emptyList(); // or return null, depending on your requirements
        } else {
            List<Chambre> chambres = bloc.getChambres();
            if (chambres == null) {
                log.info("Ce bloc n'a pas de chambre.");
                return Collections.emptyList(); // or return null, depending on your requirements
            } else {
                System.out.println(chambres);
                return chambres;
            }
        }
    }


    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b=blocrep.findById(idBloc).get();
        Long nb = 0L;
        List <Chambre> listchambre = new ArrayList<>();
        listchambre =  b.getChambres();
        for (int i=0;i<listchambre.size();i++){
            if( listchambre.get(i).getType() == type )
            {
                nb+=1;
            }
        }
        return nb;

    }

//@Scheduled(fixedRate = 300000)
//    void pourcentageChambreParTypeChambre(){
//        int nbchambre = chambrerep.findAll().size();
//        log.info("nombre de chambre est : "+nbchambre);
//    log.info("le pourcentage  de type simple est  : " + (chambrerep.getnbchambrebytype(SIMPLE)*100)/nbchambre+"%");
//    log.info("le pourcentage  de type double est  : " + (chambrerep.getnbchambrebytype(DOUBLE)*100)/nbchambre+"%");
//    log.info("le pourcentage  de type triple est  : " + (chambrerep.getnbchambrebytype(TRIPLE)*100)/nbchambre+"%");
//    }


//    @Scheduled(fixedRate = 10000)
//    void nbPlacesDisponibleParChambreAnneeEnCours(){
//        List<Chambre> listchambre = chambrerep.findAll();
//        List<Reservation> listRes = resRep.findAll();
//
//        listRes.stream().forEach(reservation -> {
//            System.out.println(reservation.getAnneUniv().after(2024-01-01 00:00:00.000000));
//        });
//
//    }



}
