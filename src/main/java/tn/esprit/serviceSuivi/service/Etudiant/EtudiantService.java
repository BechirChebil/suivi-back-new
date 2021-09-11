package tn.esprit.serviceSuivi.service.Etudiant;

import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.repositories.Etudiant.IEtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiantService {

    IEtudiantRepository IEtudiantRepository;

    public EtudiantService(IEtudiantRepository IEtudiantRepository) {
        this.IEtudiantRepository = IEtudiantRepository;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return IEtudiantRepository.save(etudiant);

    }


    @Override
    public Etudiant updateEtudiant(Etudiant etudiantToUpdate, Etudiant etudiant) {
//        etudiantToUpdate.setTitre(etudiant.getTitre() != null ? etudiant.getTitre() : etudiantToUpdate.getTitre());
//        etudiantToUpdate.setDiscription(etudiant.getDiscription() != null ? etudiant.getDiscription() : etudiantToUpdate.getDiscription());
//        etudiantToUpdate.setRendu(etudiant.getRendu() != null ? etudiant.getRendu() : etudiantToUpdate.getRendu());
//        etudiantToUpdate.setStartTime(etudiant.getStartTime() != null ? etudiant.getStartTime() : etudiantToUpdate.getStartTime());
//        etudiantToUpdate.setEndTime(etudiant.getEndTime()  != null ? etudiant.getEndTime() : etudiantToUpdate.getEndTime());
//
//        if (etudiant.getSeance() != null) {
//            etudiantToUpdate.setSeance(etudiant.getSeance());
//        }

        IEtudiantRepository.save(etudiantToUpdate);
        return etudiantToUpdate;
    }

    @Override
    public Etudiant getEtudiant(Long etudiantId) {
        Optional<Etudiant> etudiant = IEtudiantRepository.findById(etudiantId);
        return etudiant.orElse(null);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return (List<Etudiant>) IEtudiantRepository.findAll();
    }

    @Override
    public void deleteEtudiant(Long etudiantId) {
        Optional<Etudiant> etudiant = IEtudiantRepository.findById(etudiantId);
        // equivalent to if etudiant.isPresent ---> delete etudiant object
        etudiant.ifPresent(value -> IEtudiantRepository.delete(value));
    }
}
