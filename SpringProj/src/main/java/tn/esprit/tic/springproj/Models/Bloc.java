package tn.esprit.tic.springproj.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "foyerr")

public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    private boolean Archived=false;
    @ManyToOne
    @JsonManagedReference
    private Foyer  foyerr;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "blocch" , fetch = FetchType.EAGER )
    @JsonBackReference
    private List<Chambre> chambres;



}
