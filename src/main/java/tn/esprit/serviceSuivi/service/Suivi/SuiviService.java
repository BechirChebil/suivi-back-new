package tn.esprit.serviceSuivi.service.Suivi;

import tn.esprit.serviceSuivi.Model.Suivi;
import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.repositories.Suivi.ISuiviRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuiviService implements ISuiviService {

    ISuiviRepository suiviRepository;

    public SuiviService(ISuiviRepository suiviRepository) {
        this.suiviRepository = suiviRepository;
    }

    @Override
    public Suivi addSuivi(Suivi suivi) {
        //suiviRepository.save(suivi);
        return suiviRepository.save(suivi);
    }


    @Override
    public Suivi updateSuivi(Suivi suiviToUpdate, Suivi suivi) {

        suiviToUpdate.setEtat(suivi.getEtat() != null ? suivi.getEtat() : suiviToUpdate.getEtat());

        suiviRepository.save(suiviToUpdate);
        return suiviToUpdate;
    }

    @Override
    public Suivi getSuivi(Long suiviId) {
        Optional<Suivi> suivi = suiviRepository.findById(suiviId);
        return suivi.orElse(null);
    }

    @Override
    public List<Suivi> getSuivis() {
        return (List<Suivi>) suiviRepository.findAll();
    }

    @Override
    public void deleteSuivi(Long suiviId) {
        Optional<Suivi> suivi = suiviRepository.findById(suiviId);
        // equivalent to if suivi.isPresent ---> delete suivi object
        suivi.ifPresent(value -> suiviRepository.delete(value));
    }
}
