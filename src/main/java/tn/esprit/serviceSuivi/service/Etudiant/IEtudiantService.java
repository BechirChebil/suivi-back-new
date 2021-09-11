package tn.esprit.serviceSuivi.service.Etudiant;

import tn.esprit.serviceSuivi.Model.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiantToUpdate, Etudiant etudiant);
    public Etudiant getEtudiant(Long etudiantId);
    public List<Etudiant> getEtudiants();
    public void deleteEtudiant(Long etudiantId);
}
