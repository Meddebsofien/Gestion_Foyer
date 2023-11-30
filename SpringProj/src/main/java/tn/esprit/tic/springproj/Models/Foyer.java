package tn.esprit.tic.springproj.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "Blocs")
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capacitiFoyer;
    private boolean archived = false;

    @OneToOne( mappedBy =  "foyer")

     private Universite universite;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "foyerr")
    @JsonBackReference
    private List<Bloc> Blocs ;


}
