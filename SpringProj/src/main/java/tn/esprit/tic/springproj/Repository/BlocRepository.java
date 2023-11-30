package tn.esprit.tic.springproj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.tic.springproj.Models.Bloc;

public interface BlocRepository  extends JpaRepository<Bloc,Long> {

    @Query(" select b from Bloc b where b.nomBloc = :nomb" )
    Bloc getblocbyNom(@Param("nomb") String nomb);

}
