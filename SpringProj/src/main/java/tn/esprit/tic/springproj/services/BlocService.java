package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Bloc;
import tn.esprit.tic.springproj.Models.Chambre;
import tn.esprit.tic.springproj.Repository.BlocRepository;
import tn.esprit.tic.springproj.Repository.ChambreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocService implements IBlocService {

    BlocRepository blocrepository;
    ChambreRepository chr;
    @Override
    public List<Bloc> retrieveBlocs() {
        return  blocrepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocrepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocrepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocrepository.findById(idBloc).get();
    }

    @Override
    public void archiverBloc(long idBloc) {
        blocrepository.getReferenceById(idBloc).setArchived(true);
    }


public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
    Bloc bloc  = blocrepository.getblocbyNom(nomBloc);
    List<Chambre> listchambre= new ArrayList<>();
    Chambre chambre ;

    for (int i=0 ; i<numChambre.size() ;i++){
        chambre = chr.getchambrebynum(numChambre.get(i));
        chambre.setBlocch(bloc);
        listchambre.add(chambre);
    }
    blocrepository.save(bloc);
    return bloc;

}
//public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
//    Bloc bloc  = blocrepository.getblocbyNom(nomBloc);
//    List<Chambre> listchambre= new ArrayList<Chambre>();
//    Chambre chambre = new Chambre();
//    for (int i=0 ; i<numChambre.size() ;i++){
//        chambre = chr.getchambrebynum(numChambre.get(i));
//
//        listchambre.add(chambre);
//    }
//    bloc.getChambres().forEach(chambre1 -> {
//        chambre1.setBlocch(bloc);
//        chr.save(chambre1);
//    });
//    blocrepository.save(bloc);
//    return bloc;
//
//}

//    @Scheduled(fixedRate = 60000)
//    public void executeEveryMinute() {
//        // for (int i =0;i<bs.retrieveBlocs().size() ;i++) {
//  List<Bloc> listallBloc = blocrepository.findAll();
//  log.info("size est : " + listallBloc.size());
//       for(int i =0 ;i<listallBloc.size();i++){
//           List<Chambre> chambres = listallBloc.get(i).getChambres();
//     log.info("bloc :" + listallBloc.get(i).getNomBloc() +"ayant un ecapacite de "  +listallBloc.get(i).getCapaciteBloc());
//           chambres.stream().forEach(chambre ->  {
//               log.info("numero chambre est "  + chambre.getNumeroChambre() + "de Type "  + chambre.getType());
//           });
//       }
//    }

}
