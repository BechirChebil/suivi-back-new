package tn.esprit.serviceSuivi.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    //@JsonIgnore
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    //@JsonIgnoreProperties("seance")
    //@JsonProperty("etudiants")
    @OneToMany(mappedBy="equipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("seance")
    private List<Etudiant> etudiants;



    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="tutor_id")//, referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore//Properties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnoreProperties({"Seances"})
    //@JsonProperty("tutor")
    private Tutor tutor;

    public Equipe() {
    }

    public Equipe(Long id, String numero, List<Etudiant> etudiants, Tutor tutor) {
        this.id = id;
        this.numero = numero;
        this.etudiants = etudiants;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    //    public Equipe(String titre, String objectif,String indicationTuteur,
//                   String indicationEtudiant, Date date, String creneau )
//    {
//
//        this.titre = titre;
//        this.objectif = objectif;
//        this.indicationTuteur = indicationTuteur;
//        this.indicationEtudiant = indicationEtudiant;
//        this.date = date;
//        this.creneau = creneau;
//    }




}
