package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Bloc;
import tn.esprit.tic.springproj.Models.Foyer;
import tn.esprit.tic.springproj.Repository.BlocRepository;
import tn.esprit.tic.springproj.Repository.FoyerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerService implements  IFoyerService{

    FoyerRepository foyerrepository;
    BlocRepository blocRep;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerrepository.findAll();

    }

    @Override
    public Foyer addFoyer(Foyer f) {
      return   foyerrepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerrepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
       return   foyerrepository.findById(idFoyer).get();

    }

    @Override
    public Foyer archiverFoyer(long idFoyer) {
        Foyer f = foyerrepository.findById(idFoyer).get();
     //   Boolean b = f.isArchived();
       f.setArchived(!(f.isArchived()));
       foyerrepository.save(f);
       return f;
    }

    @Override
    public Foyer addFoyerWithBloc(Foyer f) {
//       Foyer foyer = foyerrepository.save(f);
//        System.out.println(1);
//        foyer.getBlocs().forEach(bloc -> {
//            bloc.setFoyerr(foyer);
//            blocRep.save(bloc);
//           });
//        System.out.println(2);
     //  foyerrepository.save(foyer);

        Foyer foyer = foyerrepository.save(f);
        List <Bloc> listbloc = new ArrayList<>();
        listbloc = f.getBlocs();
        Bloc b = new Bloc();
        for(int i = 0 ; i<listbloc.size();i++){
            b= blocRep.findById(listbloc.get(i).getIdBloc()).get();
            b.setFoyerr(foyer);
            blocRep.save(b);
        }
       return foyer;
    }
}
