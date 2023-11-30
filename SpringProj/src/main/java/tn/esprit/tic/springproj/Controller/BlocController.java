package tn.esprit.tic.springproj.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.Bloc;
import tn.esprit.tic.springproj.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")

public class BlocController {

    IBlocService  blocs;


    @GetMapping ("/get")
//    @Operation(description = "afficher tous les blocs")
    public List<Bloc> getAllBlocs(){
      return   blocs.retrieveBlocs();
    }

    @PostMapping("/addBloc")
   public  Bloc AjouterBloc ( @RequestBody Bloc b){
        Bloc bloc = blocs.addBloc(b);
        return  bloc;

    }

    @GetMapping("/getblocbyId/{idbloc}")
   public Bloc getBlocById ( @PathVariable("idbloc")  long idbloc){
        return  blocs.retrieveBloc(idbloc);

    }
@PutMapping("/archivebloc/{idb}")
    void archiverBloc ( @PathVariable("idb") long idb){
         blocs.archiverBloc (idb);

    }
   @PostMapping("/affecte-chambres-bloc/{nomBloc}/chambre")
    public Bloc affecterChambresABloc (@PathVariable("nomBloc") String nomBloc ,  @RequestBody List<Long> numChambre ){
           return     blocs.affecterChambresABloc(numChambre,nomBloc);
    }
}
