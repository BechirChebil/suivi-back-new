package tn.esprit.serviceSuivi.repositories.Etudiant;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.serviceSuivi.Model.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant, Long> {
}
