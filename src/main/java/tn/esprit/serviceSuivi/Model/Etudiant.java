package tn.esprit.serviceSuivi.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String classe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name="equipe_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore//Properties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnoreProperties({"Phases"})rfrfr
    //@JsonProperty("equipe")
    private Equipe equipe;


    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String prenom, String mail, String classe, Equipe equipe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.classe = classe;
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }



//    public Etudiant(String titre, String rendu, String discription, Date startTime, Date endTime) {
//        this.titre = titre;
//        this.rendu = rendu;
//        this.discription = discription;
//        this.startTime = startTime;
//        this.endTime = endTime;
//
//    }






}
